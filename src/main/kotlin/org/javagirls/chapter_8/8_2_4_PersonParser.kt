package org.javagirls.chapter_8

import org.javagirls.chapter_7.Person

class `8_2_4_PersonParser`: DataParser<Person> {
    override fun parseData(
        input: String,
        output: MutableList<Person>,
        errors: MutableList<String?>) {

        println("parsing data")
    }
}

fun main() {
    val personPerson = `8_2_4_PersonParser`()
    personPerson.parseData("teste", mutableListOf(Person("Name", null, "email")), mutableListOf(null))
}