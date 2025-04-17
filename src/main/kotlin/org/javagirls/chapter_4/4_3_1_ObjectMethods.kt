package org.javagirls.chapter_4

class Customer(val name: String, val postalCode: Int) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Customer) return false

        if (name != other.name) return false
        if (postalCode != other.postalCode) return false

        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + postalCode
        return result
    }
}

fun main() {
    /*
    val customer = Customer("Alice", 349340)
    val customer1 = Customer("Alice", 349340)
    println(customer)
    println(customer1)
    println(customer == customer1)
    println(customer.hashCode())
    println(customer1.hashCode())
    */

    // HashSet
    val processed = hashSetOf(Customer("Alice", 349340))
    println(processed.contains(Customer("Alice", 349340)))

    processed.forEach { item -> println(item.hashCode())}
    println(Customer("Alice", 349340).hashCode())

}

