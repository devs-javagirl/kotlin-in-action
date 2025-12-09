package org.javagirls.chapter_11

fun printContents(list: List<Any>) {
    println(list.joinToString())
}

fun addAnswer(list: MutableList<Any>) {
    list.add(12)
}

fun <T> addAnswerMutable(list: MutableList<T>, element: T) {
    list.add(element)
}

fun main() {
    //printContents(listOf("abc", "bac"))

    val strings = mutableListOf("abc", "bac")
    // no livro aponta erro ClassCastException: Integer cannot be cast to String
    // no compilador -> type mismatch required MutableList<any>
    // addAnswer(strings)

    addAnswerMutable(strings, "efg")
    println(strings)

    println(strings.maxBy { it. length })
}