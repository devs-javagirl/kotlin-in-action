package org.javagirls.chapter_6

val peopleSequence= listOf(
    Person("Alice", 45),
    Person("Bob", 15),
    Person("Charles", 35),
    Person("Dan", 23)
)

fun main() {
    val nameSequence = peopleSequence
        .asSequence()
        .filter { it.name.startsWith("A") } //filter before mapping reduce time and memory usage
        .map(Person::name)
        .toList()

    println(nameSequence)

    println(peopleSequence.map(Person::name).filter { it.startsWith("A")})
}
