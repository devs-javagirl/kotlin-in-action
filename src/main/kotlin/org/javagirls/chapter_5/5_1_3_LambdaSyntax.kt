package org.javagirls.chapter_5

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
    println(people.maxByOrNull({ p: Person -> p.age }))
    println(people.maxByOrNull() { p: Person -> p.age })
    println(people.maxByOrNull { p: Person -> p.age })
    println(people.maxByOrNull { p -> p.age })
    println(people.maxByOrNull { it.age })
    println(people.maxByOrNull(Person::age))

    val getAge = { p: Person -> p.age }
    people.maxByOrNull(getAge)

    val sum = { x: Int, y: Int ->
        println("Computing the sum of $x and $y ... ")
        x + y
    }
    println(sum(1, 2))

}