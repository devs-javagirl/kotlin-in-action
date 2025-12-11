package org.javagirls.chapter_11

fun printContents(list: List<Any>) {
    println(list.joinToString())
}

fun addAnswer(list: MutableList<Any>) {
    list.add(12)
}

fun <T> addAnswerMutable(list: MutableList<T>, element: T) {
    list.add(element)
    //list.add(12)
}

fun main() {
    printContents(listOf("abc", "bac"))
    printContents(listOf(1, 2, 3))
    printContents(listOf(1, "abc", 5L))

    //Mix types in a collection, Kotlin will infer the type as MutableList<Any>
    println("Teste de mutable list com vários tipos")
    val test = mutableListOf("abc", 42, 1L)
    println(test)

    for (element in test) {
        println("${element} is of type ${element::class.simpleName}")
    }

    // no livro aponta erro ClassCastException: Integer cannot be cast to String
    // no compilador -> type mismatch required MutableList<any>
    val strings = mutableListOf("abc", "bac")
    // addAnswer(strings)

    addAnswerMutable(strings, "efg")
    // addAnswerMutable(strings, 12)
    println(strings)

    println(strings.maxBy { it. length })


}