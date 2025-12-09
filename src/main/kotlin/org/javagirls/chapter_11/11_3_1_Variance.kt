package org.javagirls.chapter_11

fun printContents(list: List<Any>) {
    println(list.joinToString())
}

fun addAnswer(list: MutableList<Any>) {
    list.add(42)
}

fun main() {
    printContents(listOf("abc", "bac"))

    val strings = mutableListOf("abc", "bac")
    //type mismatch required MutableList<any>
    //addAnswer(strings)

    println(strings.maxBy { it. length })
}