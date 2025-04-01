package org.javagirls.chapter_4

class Customer(val name: String, val postalCode: Int) {
    //override fun toString() = "Customer(name='$name', postalCode=$postalCode)"

    /*
    override fun equals(other: Any?): Boolean {
        if (other == null || other !is Customer)
            return false
        return name == other.name && postalCode == other.postalCode
    } */

    /*
    override fun hashCode(): Int = name.hashCode() * 31 + postalCode
    */

}

fun main() {
    val customer = Customer("Alice", 349340)
    val customer1 = Customer("Alice", 349340)
    println(customer)
    println(customer1)
    println(customer == customer1)
    println(customer.hashCode())
    println(customer1.hashCode())

    // HashSet
    /*
    val processed = hashSetOf(Customer("Alice", 349340))
    println(processed.contains(Customer("Alice", 349340)))

    processed.forEach { item -> println(item.hashCode())}
    println(Customer("Alice", 349340).hashCode())
     */

}

