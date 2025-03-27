package org.javagirls.chapter_4

abstract class Animated {
    /*
    Classe abstrata não podemos instanciar
    A função animate é abstrata e deve ser implementada por subclasses
    Funções não abstratas em classes abstratas não são abertas por padrão,
    mas podem ser marcadas com a palavra-chave open
     */
    abstract val animationSpeed: Double
    val keyframes: Int = 20
    open val frames: Int = 60

    abstract fun animate()
    open fun stopAnimating() {}
    fun animateTwice() {}
}
