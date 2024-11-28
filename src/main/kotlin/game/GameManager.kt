package de.Neb.game

import GameContainer
import Image
import de.Neb.abstractGame
import de.Neb.gfx.ImageTile
import de.Neb.renderer
import game.testrender


import java.awt.event.KeyEvent
import java.awt.event.MouseEvent

open class GameManager{
    var playerx = 10
    var playery = 10
    var imagetile: ImageTile
    var image: Image
    var BLOCKWIDTH = 16
    var BLOCKHEIGHT = 16
    var rowswith = 7
    var rowHeight = 20
    var blocks: IntArray = IntArray(7 * 20)

    init {
        image = Image("title.png")
        imagetile = ImageTile("title.png", 16, 16)
    }



}



fun main() {
    val gc = GameContainer(testrender())
    gc.width = 200
    gc.height = 200
    gc.scale = 3f
    gc.fps_limit = 120.0
    gc.start()
}