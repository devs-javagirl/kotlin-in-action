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

    val authorsFlatMap = library.flatMap { it.authors }
    println(authorsFlatMap)
    println(authorsFlatMap.toSet())
}