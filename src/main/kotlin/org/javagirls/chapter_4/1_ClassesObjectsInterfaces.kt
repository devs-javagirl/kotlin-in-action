package org.javagirls.chapter_4

interface Clickable {
    /*
        4.1 Definindo uma interface
     */
    fun click()
    /*
        4.3 Definindo um método com implementação em uma interface
        Implementação padrão
     */
    fun showOff() = println("I'm clickable!")
}
class Button : Clickable {
    /*
        4.2 Implementando uma interface Simples
     */
    override fun click() = println("I was clicked")
}


interface Focusable {
    /*
        4.4 Definindo outra interface que implementa o mesmo método
     */
    fun setFocus(b: Boolean) = println("I ${if (b) "got" else "lost"} focus.")
    fun showOff() = println("I'm focusable!")
}

class Button2 : Clickable, Focusable {
    /*
        4.5 Implementando duas interfaces
     */
    override fun click() = println("I was clicked")
    override fun showOff() {
        /*
            Chamando explicitamente a implementação de uma superclasse
            O super qualificado com o nome do supertipo entre <> permite chamar a implementação de um método de uma superclasse específica
         */
        super<Clickable>.showOff()
        super<Focusable>.showOff()
    }
}

fun main() {
    val button = Button2()
    button.showOff()
    button.setFocus(true)
    button.click()
}

