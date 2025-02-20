package org.javagirls.chapter_2

fun main() {
    println("KOTLIN --------------------------")
    // construtor sem uso de new
    val person = Person("Bob", true)
    // acesso direto a propriedade name, mas o getter é invocado
    println(person.name)
    println(person.isStudent)
    //acesso direto a propriedade, mas o setter é invocado
    person.isStudent = false
    println(person.isStudent)
}