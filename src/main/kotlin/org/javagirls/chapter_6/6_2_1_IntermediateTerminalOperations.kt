package org.javagirls.chapter_6

fun numbers() {
    println(listOf(1, 2, 3, 4)
        .asSequence()
        .map {
            print("map($it) ")
            it * it
        }.filter {
            print("filter($it) ")
            it % 2 == 0
        }
    )
}

fun numbersToList() {
    val result = listOf(1, 2, 3, 4)
        .asSequence()
        .map {
            print("map($it) ")
            it * it
        }.filter {
            print("filter($it) ")
            it % 2 == 0
        }.toList()

    println("terminal operation toList -> $result")
}

fun numberFind() {
    val result = listOf(1, 2, 3, 4)
        .asSequence()
        .map { it * it }
        .find { it > 3 }

    println("terminal operation find -> $result")
}

fun peopleSequence() {
    val nameMapFirst = peopleSequence
        .asSequence()
        .map(Person::name)
        .filter { it.length < 4 }
        .toList()

    println(nameMapFirst)

    val nameFilterFirst = peopleSequence
        .asSequence()
        .filter { it.name.length < 4 }
        .map(Person::name)
        .toList()

    println(nameFilterFirst)

}

fun main() {
    numbers()
    numbersToList()
    numberFind()
    peopleSequence()
}