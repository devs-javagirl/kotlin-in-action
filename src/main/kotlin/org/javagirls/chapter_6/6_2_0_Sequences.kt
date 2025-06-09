package org.javagirls.chapter_6

val peopleSequence= listOf(
    Person("Alice", 45),
    Person("Bob", 15),
    Person("Charles", 35),
    Person("Dan", 23)
)

fun main() {
    println(peopleSequence.map(Person::name).filter { it.startsWith("A")})

    val nameSequence = peopleSequence
        .asSequence()
        .map(Person::name)
        .filter { it.startsWith("A") }
        .toList()

    println(nameSequence)
}