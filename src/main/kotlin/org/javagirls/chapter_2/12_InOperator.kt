package org.javagirls.chapter_2

// verifica se o caracter está entre a e z ( a <= c <= z )
fun isLetter(c: Char) = c in 'a'..'z' || c in 'A' .. 'Z'
// verifica se o caracter está entre 0 e 9 ( 0 <= c <= 9 )
fun isNotDigit(c: Char) = c !in '0'..'9'

fun recognize(c: Char) = when (c) {
    // verifica se o caracter entá entre 0 e 9
    in '0'..'9' -> "It's a digit!"
    // combinação de múltiplos ranges
    in 'a'..'z', in 'A'..'Z' -> "It's a letter!"
    else -> "I don't know..."
}

// range não é restrito a caracter, pode ser utilizado com
// qualquer classe que implementa a inferface Kotlin.Comparable
// no caso da classe String, é verificado a ordem alfabética
// e com o operador in é verificado se Java <= Kotlin <= Scala
fun language() = "Kotlin" in "Java" .. "Scala"

fun main() {
    println("A is letter ? ${isLetter('A')}")
    println("9 is letter ? ${isLetter('9')}")
    println("A is not digit ? ${isNotDigit('A')}")
    println("A -> ${recognize('A')}")
    println("Kotlin está entre Java e Scala ? ${language()}")
}