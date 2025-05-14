package org.javagirls.chapter_5

import java.time.LocalDate


fun main() {
    val people = listOf(Person("Alice", 29), Person("Bob", 31))
    // lambda no formato verboso
    println(people.maxByOrNull({ person: Person -> person.age }))
    // member reference
    println(people.maxByOrNull(Person::age))

    // referência para função top level
    run(::salute)

    // referência para o construtor, adiando a criação da instância
    val createPerson = ::Person
    val p = createPerson("Maria", 17, LocalDate.of(2008, 3,4))
    println(p)

    // referência para extension function
    val predicate = Person::isAdult
    println(predicate(p))

}

fun salute() = println("Salute")

fun Person.isAdult() = age >= 21