package org.javagirls.chapter_10

val people_ = listOf(Person_("Alice", 29), Person_("Bob", 31))

fun lookForAlice(people: List<Person_>) {
    for (person in people) {
        if (person.name == "Alice") {
            println("Found in for!")
            return
        }
    }
    println("Alice not found")
}

fun lookForAliceForEach(people: List<Person_>) {
    people.forEach {
        if (it.name == "Alice") {
            println("Found in foreach!")
            return
        }
    }
    println("Alice not found")
}

// teste lambda sem inline, não permite return
fun doLater(action: () -> Unit) {
    // Store the lambda for later use
    val stored = action
    // ... might call stored() later
    stored.invoke()
}

fun test() {
    doLater {
        println("doLater")
        // return // ERROR: 'return' is not allowed here
    }
}

// teste lambda com inline, permite return na outline function
inline fun doNow(action: () -> Unit) {
    action()
}

fun testReturn() {
    doNow {
        println("doNow")
        return // This returns from test()
    }
    println("This will not print")
}


fun main() {
    lookForAlice(people_)

    lookForAliceForEach(people_)

    test()

    testReturn()


}