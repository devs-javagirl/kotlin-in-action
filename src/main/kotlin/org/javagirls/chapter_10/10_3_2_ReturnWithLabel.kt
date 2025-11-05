package org.javagirls.chapter_10

fun lookForAliceLabel(people: List<Person_>) {
    println(people_)
    people.forEach label@{
        println(it.name)
        if (it.name != "Alice") return@label
        println("Found Alice label")
    }
}

fun lookForAliceLabel1(people: List<Person_>) {
    people.forEach {
        println(it.name)
        if (it.name != "Alice") return@forEach
        println("Found Alice label1")
    }
}


fun main() {
    lookForAliceLabel(people_)

    lookForAliceLabel1(people_)

    println(StringBuilder().apply sb@{
        listOf(1, 2, 3).apply {
            this@sb.append(this.toString())
        }
    })
}