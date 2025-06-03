package org.javagirls.chapter_6

val canBeInClub28 = { p: Person -> p.age <= 28 }

val peoplePredicate = listOf(Person("Alice", 27), Person("Bob", 31))

val numbersList = listOf(1, 2, 3)

fun main() {
    println(peoplePredicate.all(canBeInClub28))
    println(peoplePredicate.any(canBeInClub28))


    // !all = any
    println(!numbersList.all { it == 3 })
    println(numbersList.any { it != 3 })

    // !any = none
    println(!numbersList.any { it == 4})
    println(numbersList.none { it == 4})

    // emptyList
    println(emptyList<Int>().any { it > 42 })
    println(emptyList<Int>().none { it > 42 })
    println(emptyList<Int>().all { it > 42 })

    // Mais eficiente
    println(peoplePredicate.count(canBeInClub28))
    // Cria coleção intermediária, depois conta os itens
    println(peoplePredicate.filter(canBeInClub28).size)
    // Retorna o item encontrado ou nulo, caso não exista
    println(peoplePredicate.find(canBeInClub28))
    // Sinônimo para find
    println(peoplePredicate.firstOrNull(canBeInClub28))
}