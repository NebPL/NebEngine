package de.Neb.gfx

import Image

class font(path:String){


    var fontImage:Image
    var offsets = IntArray(90)
    var width = IntArray(90)

    init {
        fontImage = Image(path)

        var unieCode:Int = 0

        for (i in 0 until fontImage.w) {
            if (fontImage.p[i] == 0xff0000ff.toInt()) {
                offsets[unieCode] = i
            }
            if (fontImage.p[i] == 0xffffff00.toInt()) {
                width[unieCode] = i - offsets[unieCode]
                unieCode++
            }
        }

    }

}