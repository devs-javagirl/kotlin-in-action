package org.javagirls.chapter_5

fun createAllDoneRunnable(): Runnable {
    return Runnable { println("All done") }
}

fun main() {
    createAllDoneRunnable().run()

    val x = Runnable{println("All done")}
    x.run()

    val calc = Calculo { x: Int, y: Int -> x + y }
    println(calc.executar(1, 4))

}

// SAM - single abstract method - interface funcional
fun interface Calculo {
    fun executar(a: Int, b:Int): Int

}


