package org.javagirls.chapter_5

fun main() {

    val seb = Person("Sebastian", 26)

    val personAgeFunction = Person::age
    println(personAgeFunction(seb))

    val sebAgeFunction = seb::age
    println(sebAgeFunction())

}