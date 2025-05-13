package org.javagirls.chapter_5

import java.time.LocalDate


fun main() {
    val people = listOf(Person("Alice", 29), Person("Bob", 31))
    println(people.maxByOrNull({ person: Person -> person.age }))
    println(people.maxByOrNull(Person::age))

    run(::salute)

    val createPerson = ::Person
    val p = createPerson("Maria", 17, LocalDate.of(2008, 3,4))
    println(p)

    val predicate = Person::isAdult
    println(predicate(p))

}

fun salute() = println("Salute")

fun Person.isAdult() = age >= 21