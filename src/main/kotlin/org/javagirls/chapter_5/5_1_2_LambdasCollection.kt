package org.javagirls.chapter_5

import java.time.LocalDate

data class Person(val name: String, val age: Int, val birthday: LocalDate = LocalDate.now())

fun findTheOldest(people: List<Person>) {
    var maxAge = 0
    var theOldest: Person? = null
    for (person in people) {
        if (person.age > maxAge) {
            maxAge = person.age
            theOldest = person
        }
    }
    println(theOldest)
}

fun main() {
    val people = listOf(Person("Alice", 29, LocalDate.of(1980, 5, 1)),
        Person("Bob", 31, LocalDate.of(1970, 5, 1)))
    findTheOldest(people)

    println(people.maxByOrNull { it.birthday })

}