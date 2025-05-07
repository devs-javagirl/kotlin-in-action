package org.javagirls.chapter_5

// ESTRUTURA DE UMA LAMBDA
// lambda sempre entre chaves
// esquerda: parâmetros -> direita: corpo da funçção

fun main() {
    { println(42) }()

    run { println(42) }

    val simpleSum = { x: Int, y: Int -> x + y }
    println(simpleSum(1, 2))

    val myFavoriteNumer = run {
        println("I'm thinking!")
        println("I'm doing some more work")
        42
    }

    val people = listOf(Person("Alice", 29), Person("Bob", 31))

    // lambda (código entre chaves) sendo passada como argumento da função
    println(people.maxByOrNull({ p: Person -> p.age }))
    // se a lambda for o último argumento da função, ela pode ser colocada fora dos parênteses
    println(people.maxByOrNull() { p: Person -> p.age })
    // quando a lambda é o único argumento da função, você pode remover os parênteses vazios
    println(people.maxByOrNull { p: Person -> p.age })
    // como está sendo utilizada uma coleção de Person, Kotlin infere o tipo, não é necessário declarar Person
    println(people.maxByOrNull { p -> p.age })
    // it = nome implícito para o único parâmetro da lambda
    println(people.maxByOrNull { it.age })
    // a lambda também pode delegar para uma função ou propriedade, podendo invocar um member reference
    println(people.maxByOrNull(Person::age))

    val getAge = { p: Person -> p.age }
    people.maxByOrNull(getAge)

    val sum = { x: Int, y: Int ->
        println("Computing the sum of $x and $y ... ")
        x + y
    }
    println(sum(1, 2))

}