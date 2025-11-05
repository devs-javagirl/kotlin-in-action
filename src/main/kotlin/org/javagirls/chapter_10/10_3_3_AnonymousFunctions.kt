package org.javagirls.chapter_10

fun lookForAliceAF(people: List<Person_>) {
    people.forEach(fun (person) {
        if (person.name == "Alice") return
        println("${person.name} is not Alice")
    })
}

fun main() {
    lookForAliceAF(people_)

    println(
        people_.filter(fun (person): Boolean {
            return person.age < 30
        })
    )

    println(
        people_.filter(fun (person) = person.age < 30)
    )
}