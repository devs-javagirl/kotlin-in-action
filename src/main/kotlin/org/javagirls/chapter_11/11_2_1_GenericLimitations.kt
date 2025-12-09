package org.javagirls.chapter_11

fun readNumbersOrWords(): List<Any> {
    println("Digite a entrada:")
    val input = readln()
    val words: List<kotlin.String> = input.split(",")
    val numbers: List<Int> = words.mapNotNull { it.toIntOrNull() }
    return numbers.ifEmpty { words }
}

fun printList(l: List<Any>) {
    when(l) {
        //is List<String> -> println("Strings: $l")
        //is List<Int> -> println("Integers: $l")
        is List<*> -> println("é uma lista")
        is Set<*> -> println("é um set")
    }
}

fun printSum(c: Collection<*>) {
    try {
        val intList = c as? List<Int>
        println(intList?.sum() ?: 0)
    } catch (e: Exception) {
        println(e)
    }
}

fun main() {
    /*
    val list = readNumbersOrWords()
    printList(list)
    if (list is List<*>) println("objeto list é uma Lista")
    if (list is Set<*>) println("objeto list é um set")
     */

    printSum(listOf(1, 2, 3))


    //IllegalArgumentException: List is expected
    printSum(setOf(1, 2, 3))

    //ClassCastException: String cannot be cast to class Number
    printSum(listOf("a", "b", "c"))
}
