package org.javagirls.chapter_6

val reducePeople = listOf(Person("Alex", 29),Person("Natalia", 28) )

fun reduceExample() {
    val list = listOf(1, 2, 3, 4)
    val summed = list.reduce { acc, element -> acc + element }
    println(summed)

    val multiplied = list.reduce { acc, element -> acc * element }
    println(multiplied)
}

fun peopleFold() {
    val folded = reducePeople.fold("") { acc, person -> acc + person.name }
    println(folded)
}

fun runningReduce() {
    val list = listOf(1, 2, 3, 4)
    val summed = list.runningReduce { acc, element -> acc + element }
    println(summed)

    val multiplied = list.runningReduce { acc, element -> acc * element }
    println(multiplied)
}

fun runningFold() {
    println(reducePeople.runningFold("") { acc, person -> acc + person.name })
}

fun main() {
    reduceExample()
    runningReduce()
    peopleFold()
    runningFold()
}
