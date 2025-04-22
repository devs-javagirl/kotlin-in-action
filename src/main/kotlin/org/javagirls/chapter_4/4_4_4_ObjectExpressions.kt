package org.javagirls.chapter_4

interface ButtonListener {
    fun onEnter()
    fun onClick()
}

class ButtonNew(private val listener: ButtonListener) {

}

fun main(){
    var clickCount = 0
    ButtonNew(object: ButtonListener {
        override fun onClick() {
            clickCount++
        }
        override fun onEnter() {}
    })

}