package org.javagirls.chapter_5

// Metodo implementando a interface funcional Runnable do Java
fun createAllDoneRunnable(): Runnable {
    return Runnable { println("All done") }
}

// SAM - single abstract method - interface funcional no Kotlin
fun interface Calculo {
    fun executar(a: Int, b:Int): Int

}

fun main() {
    createAllDoneRunnable().run()

    val y = Runnable { println("All done") }
    y.run()

    val calc = Calculo { x: Int, y: Int -> x + y }
    println(calc.executar(1, 4))

}




