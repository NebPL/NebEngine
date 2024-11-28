import de.Neb.Input
import de.Neb.Window
import de.Neb.abstractGame
import de.Neb.renderer

class GameContainer(game: abstractGame?) : Runnable {

    var fps_limit: Double = 60.0
        set(value) {
            field = if (value <= 0) 60.0 else value // Mindest-FPS 1, um Division durch 0 zu vermeiden
        }

    private val updateCap: Double
        get() = 1.0 / fps_limit // Dynamisch basierend auf fps_limit

    var window: Window? = null
    var renderer: renderer? = null
    lateinit var input: Input
    var game = game

    var thread = Thread()
    var running = false

    var width: Int = 1600
    var height: Int = 100
    var scale: Float = 1f
    var title: String = "Game"

    fun start() {
        window = Window(this)
        input = Input(this)
        renderer = renderer(this)
        thread = Thread(this)
        thread.start() // Thread starten
    }

    fun stop() {
        running = false
    }

    override fun run() {
        running = true

        var render: Boolean
        var firstTime: Double
        var lastTime: Double = System.nanoTime() / 1000000000.0
        var passedTime: Double
        var unprocessedTime: Double = 0.0

        var frameTime: Double = 0.0
        var frames = 0
        var fps = 0

        while (running) {
            render = false
            firstTime = System.nanoTime() / 1000000000.0
            passedTime = firstTime - lastTime
            lastTime = firstTime

            unprocessedTime += passedTime
            frameTime += passedTime

            while (unprocessedTime >= updateCap) { // updateCap wird hier dynamisch berechnet
                unprocessedTime -= updateCap

                // Update logik
                game?.update(this, updateCap.toFloat())
                input?.update()

                render = true

                if (frameTime >= 1.0) {
                    frameTime = 0.0
                    fps = frames
                    frames = 0
                }
            }

            if (render) {
                renderer?.clear()

                // FPS-Anzeige rendern
                renderer?.drawText("Fps: $fps", 10, 10, 0xff0000ff.toInt())
                game?.render(this, renderer!!)
                window?.update()
                frames++
            } else {
                // Warten, um CPU zu entlasten
                Thread.sleep(1)
            }
        }

        dispose()
    }

    private fun dispose() {
        // Ressourcen freigeben
    }
}
