package org.javagirls.chapter_6

data class Person(val name: String, val age: Int)

val people = listOf( Person("Alice", 29), Person("Bob", 31))

fun evenNumbers() {
    val list = listOf(1, 2, 3, 4)
    println(list.filter { it % 2 == 0 })
}

fun peopleOlderThan30() {
    println(people.filter { it.age > 30})
}

fun numberSquare() {
    val list = listOf(1, 2, 3, 4)
    println(list.map { it * it })
}

fun printName() {
    println(people.map { it.name})
    println(people.map { Person::name})
}

fun getNamePeopleOlderThan30() {
    println(people.filter { it.age > 30}
        .map { it.name
        })
}

fun getOldestPerson() {
    println(people.filter {
        val oldestPerson = people.maxByOrNull(Person::age)
        it.age == oldestPerson?.age
    })
}

fun getOldestPersonImproved() {
    val maxAge = people.maxByOrNull(Person::age)?.age
    println(people.filter { it.age == maxAge })
}

fun numbersIndexed() {
    val numbers = listOf(1, 2, 3, 4, 5, 6, 7)
    val filtered = numbers.filterIndexed { index, element ->
        index % 2 == 0 && element > 3
    }
    println(filtered)
    val mapped = numbers.mapIndexed { index, element ->
        index + element
    }
    println(mapped)

}

fun numbersUppercase() {
    val numbers = mapOf(0 to "zero", 1 to "one")
    println(numbers.mapValues { it.value.uppercase()})
}

fun main() {
    evenNumbers()
    peopleOlderThan30()
    numberSquare()
    printName()
    getNamePeopleOlderThan30()
    getOldestPerson()
    getOldestPersonImproved()
    numbersIndexed()
    numbersUppercase()
}