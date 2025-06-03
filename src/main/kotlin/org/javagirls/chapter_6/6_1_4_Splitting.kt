package org.javagirls.chapter_6

val splittingPeople = listOf(
    Person("Alice", 26),
    Person("Bob", 29),
    Person("Carol", 31))

val canBeInClub27 = { p: Person -> p.age <= 27}

val comeIn = splittingPeople.filter(canBeInClub27)
val stayOut = splittingPeople.filterNot(canBeInClub27)

fun main() {
    println(comeIn)
    println(stayOut)

    val (comeIn, stayOut) = splittingPeople.partition(canBeInClub27)
    println(comeIn)
    println(stayOut)
}