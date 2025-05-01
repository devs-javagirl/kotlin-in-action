package org.javagirls.chapter_4

interface ButtonListener {
    fun onEnter()
    fun onClick()
}

class ButtonNew(private val listener: ButtonListener) {
    fun click() {
        listener.onClick()
    }

    fun enter() {
        listener.onEnter()
    }

}

fun main(){
    var clickCount = 0
    val button = ButtonNew(object: ButtonListener {
        override fun onClick() {
            clickCount++
            println("cliquei no botão $clickCount vez(es)")
        }
        override fun onEnter() {
            println("enter no botão")
        }
    })

    button.click()
    button.enter()
    button.click()


}