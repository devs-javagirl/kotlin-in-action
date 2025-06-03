package org.javagirls.chapter_6

val groupByPeople = listOf(
    Person("Alice", 31),
    Person("Bob", 29),
    Person("Carol", 31))

val list = listOf("apple", "apricot", "banana", "cantaloup")

fun main() {
    println(groupByPeople.groupBy { it.age })
    println(list.groupBy(String::first))
}