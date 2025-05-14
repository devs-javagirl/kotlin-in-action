package org.javagirls.chapter_5

fun main() {

    val seb = Person("Sebastian", 26)

    // referência para a propriedade age da classe Person
    val personAgeFunction = Person::age
    println(personAgeFunction(seb))

    // referência para a propriedade age da instância seb
    val sebAgeFunction = seb::age
    println(sebAgeFunction())

}