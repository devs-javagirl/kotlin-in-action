package org.javagirls.chapter_5

fun main() {
    val fruits = listOf("Apple", "Banana", "Cherry")
    println("fruits $fruits")

    val uppercaseFruits = mutableListOf<String>()
    val reversedLongFruits = fruits
        .map { it.uppercase() }
        .also { uppercaseFruits.addAll(it) }
        .filter { it.length > 5 }
        .also { println("fruits length > 5 $it") }
        .reversed()

    println("fruits $fruits")
    println("uppercase fruits $uppercaseFruits")
    println("reversed fruits $reversedLongFruits")
}