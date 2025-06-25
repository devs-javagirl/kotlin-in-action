package org.javagirls.chapter_6

class Book(val title: String, val authors: List<String>)

val library = listOf(
    Book("Kotlin in Action", listOf("Isakova", "Elzarov", "Aigner", "Jemerov")),
    Book("Atomic Kotlin", listOf("Eckel", "Isakova")),
    Book("The Three-Body Problem", listOf("Liu"))
)

fun main() {
    val authors = library.map { it.authors }
    println(authors)
    println("flatten -> ${authors.flatten()}")

    val authorsFlatMap = library.flatMap { it.authors }
    println("flatMap -> $authorsFlatMap")
    println("flatMap.toSet -> ${authorsFlatMap.toSet()}")

    val numbers = listOf(listOf(1, 4, 7, 0), listOf(8,  2, 1))
    println(numbers)
    println(numbers.flatten())


}