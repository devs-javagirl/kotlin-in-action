package org.javagirls.chapter_11


fun main() {
    val letters = ('a'..'z').toList()
    println(letters.slice<Char>(0..2))
    println(letters.slice(10..13))

    val authors = listOf("Sveta", "Seb", "Roman", "Dima")
    val readers = mutableListOf("Seb", "Hadi")
    println(readers.filter { it !in authors })

    // NÃO É PERMITIDO TYPE PARAMETER PARA PROPRIEDADE DE NON-EXTENSION FUNCTION
    // val <T> x: T = println("type parameter para propriedade")
}

//fun <T> List<T>.filter(predicate: (T) -> Boolean): List<T>



