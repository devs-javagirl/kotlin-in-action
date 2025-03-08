package org.javagirls.chapter_2

// range é um intervalo entre 2 valores (normalmente números)
// valor inicial | operador .. | valor final
// range são fechados e inclusivos, o primeiro e segundo valor sempre fazem parte do range
fun simpleRange() {
    val oneToTen = 1..10
    println(oneToTen)
    oneToTen.forEach { println(it) }
}

fun fizzBuzz(i: Int) = when {
    i % 15 == 0 -> "FizzBuzz "
    i % 3 == 0 -> "Fizz "
    i % 5 == 0 -> "Buzz "
    else -> "$i"
}

fun main() {
    simpleRange()

    // range crescente
    println("range crescente ...............")
    for (i in 1..30) {
        println(fizzBuzz(i))
    }

    // range decrescente, pulando 2 itens
    println("range decrescente ..................")
    for (i in 30 downTo 1 step 2) {
        println(fizzBuzz(i))
    }
}