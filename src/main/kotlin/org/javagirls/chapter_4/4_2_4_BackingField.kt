package org.javagirls.chapter_4

// uso de backing field
class UserBacking(val name: String) {
    var address: String = "unspecified"
    set(value: String) {
        println("""
            Address was changed for $name:
            "$field" -> "$value".
        """.trimIndent())
        field = value
    }
}

// definição do setter sem uso de backing field
class Person(var birthYear: Int) {
    var ageIn2050
        get() = 2050 - birthYear
        set(value) {
            birthYear = 2050 - value
        }
}

fun main() {
    val user = UserBacking("Daniela")
    user.address = "Av Paulista, 900"

    val person = Person(2040)
    println("age in 2050 is ${person.ageIn2050}")
    person.birthYear = 2045
    println("age in 2050 is ${person.ageIn2050}")
}