package game

import GameContainer
import de.Neb.abstractGame
import de.Neb.gfx.ImageTile
import de.Neb.renderer
import java.awt.event.KeyEvent
import java.awt.event.MouseEvent

class testrender : abstractGame() {
    var playerx = 10
    var playery = 10
    var BLOCKWIDTH = 16
    var BLOCKHEIGHT = 16
    var rowswith = 7
    var rowHeight = 20
    var blocks: IntArray = IntArray(7 * 20)

    var temp: Float = 0.0f
    override fun update(gc: GameContainer, dt: Float) {

        if(gc.input?.isKey(KeyEvent.VK_A)!!){
            playerx -= 3

        }
        if(gc.input?.isKey(KeyEvent.VK_D)!!){
            playerx += 3

        }
        if(gc.input?.isKey(KeyEvent.VK_W)!!){
            playery -= 3

        }
        if(gc.input?.isKey(KeyEvent.VK_S)!!){
            playery += 3
        }

        if (gc.input?.isButton(MouseEvent.BUTTON1) == true) {
            println("Linke Maustaste gedrückt")
        }

//        if(gc.input?.isKey(KeyEvent.VK_SPACE)!! && playery >= gc.height-30){
//            playery -= 30
//
//        }
//
//        if(!(playery >= gc.height-30)){
//            playery += 5
//        }


        temp += dt*1

        if (temp > 3){
            temp = 0.0F
        }

    }


    override fun render(gc: GameContainer, r: renderer) {
        var x:Int = 10
        var y:Int = 10
//        b.renderButton("test",10,10,100,100,0x00FFFF,r)
//        r.drawImage(image,gc.input.mouseX-32,gc.input.mouseY-32)
//        r.drawImage(image,10,10)
//        r.drawImgeTitle(imagetile,10,10,temp.toInt(),0)

        r.drawBorder(playerx,playery,30,30,1,0xFFFFFFFF.toInt())
    }
}