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
class Person(var birthYear: Int, var name: String) {
    var ageIn2050
        get() = 2050 - birthYear
        set(value) {
            birthYear = 2050 - value
        }
}

fun main() {
    val user = UserBacking("Daniela")
    user.address = "Av Paulista, 900"
    println(user.address)

    val person = Person(2040, "Maria")
    println("idade em 2050 para nascimento em 2040 é ${person.ageIn2050}")
    person.birthYear = 2045
    println("idade em 2050 para nascimento em 2045 é ${person.ageIn2050}")
    person.ageIn2050 = 20
    println("considerando a idade de 20 anos em 2050, o ano de nascimento é ${person.birthYear}")
}