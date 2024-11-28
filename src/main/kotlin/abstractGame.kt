package de.Neb

import GameContainer


abstract class abstractGame {
    abstract fun update(gc:GameContainer,dt:Float)
    abstract fun render(gc:GameContainer,r:renderer)


}