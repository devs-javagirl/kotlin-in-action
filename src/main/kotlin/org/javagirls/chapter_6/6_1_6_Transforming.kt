package org.javagirls.chapter_6

val transformingPeople = listOf(Person("Joe", 22),
    Person("Mary", 31),
    Person("Jamie", 22))

fun main() {
    // key-value pair
    val nameToAge = transformingPeople.associate { it.name to it.age }
    //println(nameToAge)
    //println(nameToAge["Joe"])

    // elemento original da coleção é a chave
    val personToAge = transformingPeople.associateWith { it.name to it.age }
    //println(personToAge)

    // lambda gera a chave do map, chave deve ser única (considerou somente último com 22 anos )
    val ageToPerson = transformingPeople.associateBy { it.name }
    println(ageToPerson)
}
