package org.javagirls.chapter_4

data class CustomerData(val name: String, val postalCode: Int)

fun main() {
    val c1 = CustomerData("Sam", 34934)
    val c2 = CustomerData("Mart", 13404)
    val c3 = CustomerData("Sam", 34934)

    println(c1)
    println("c1 == c2: ${c1 == c2}")
    println("c1 == c3: ${c1 == c3}")

    println(c1.hashCode())
    println(c3.hashCode())

    val processed = hashSetOf(c1, c2)
    println(processed.contains(c3))

    println("referência de c1 é igual a c3 ? ${c1 === c3}")

    val c4 = c2.copy(name = "John")
    println(c4)

}