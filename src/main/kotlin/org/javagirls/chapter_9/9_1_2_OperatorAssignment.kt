package org.javagirls.chapter_9

operator fun<T> MutableCollection<T>.plusAssign(element: T) {
    this.add(element)

}

fun main() {
    var point = Point(1, 2)
    point += Point(3, 4)
    println("Plus assignment -> ${point}")

    val numbers = mutableListOf<Int>()
    numbers += 42
    println("Plus assignment on collection -> ${numbers[0]}")

    numbers -= 42
    println("Minus assignment on collection -> ${numbers.size}")

    val list = mutableListOf(1, 2)
    list += 3
    println("list -> $list")

    val newList = list + listOf(4, 5)
    println("newList -> $newList")
}

