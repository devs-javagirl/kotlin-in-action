package org.javagirls.chapter_7

fun greet(name: String?) {
    val recipient: String = name ?: "unnamed"
    println("Hello, $recipient!")
}



fun main() {
    greet("Gisele")
    greet(null)

    println(strLenSafeElvis("abc"))
    println(strLenSafeElvis(null))

    val address = Address("Elsestr, 47", 80687, "Mnich", "Germany")
    val jetbrains = Company("JetBrains", address)
    val person = Person("Dmitry", jetbrains)
    printShippingLabel(person)

    //printShippingLabel(Person("Alexey", null))
}

fun strLenSafeElvis(s: String?): Int = s?.length ?: 0

fun Person.countryNameElvis() = company?.address?.country ?: "Unknown"

fun printShippingLabel(person: Person) {
    val address = person.company?.address
        ?: throw IllegalArgumentException("No address")

    with(address) {
        println(streetAddress)
        println("$zipCode $city, $country")
    }
}