package org.javagirls.chapter_6

val names = listOf("Joe", "Mary", "Jamie")
val ages = listOf(22, 31, 31, 44, 0)
val countries = listOf("DE", "NL", "US")

fun main() {
    println(names.zip(ages))
    println(names.zip(ages) { name, age -> Person(name, age)})
    println(names zip ages zip countries)
}