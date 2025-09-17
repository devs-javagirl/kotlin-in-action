package org.javagirls.chapter_9

data class PersonDestructuring(
    val firstName: String,
    val lastName: String,
    val age: Int,
    val city: String,
)

fun introducePerson(p: PersonDestructuring) {
    val (firstName, lasName, age, city) = p
    println("introducePerson -> This is $firstName, aged $age.")
}

fun introducePersonBetter(p: PersonDestructuring) {
    val (firstName, _, age) = p
    println("introducePersonBetter -> This is $firstName, aged $age.")
}

fun main() {
    val person = PersonDestructuring("Maria", "Sales", 45, "Rio de Janeiro")
    introducePerson(person)
    introducePersonBetter(person)
}