package org.javagirls.chapter_10

data class Person_(val name: String, val age: Int)

val people = listOf(Person_("Alice", 29), Person_("Bob", 31))

fun main() {
    println(people.filter { it.age < 30})

    val result = mutableListOf<Person_>()
    for (person in people) {
        if (person.age < 30) result.add(person)
    }
    println(result)

    println(
        people.filter { it.age < 30 }
            .map(Person_::name)
    )
}
