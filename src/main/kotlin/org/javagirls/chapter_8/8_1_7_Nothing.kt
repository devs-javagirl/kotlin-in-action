package org.javagirls.chapter_8

import org.javagirls.chapter_7.Company

fun fail(message: String): Nothing {
    throw IllegalStateException(message)
}

fun main() {

    // Example 1
    fail("Error occured")

    // Example 2
    val company = Company("xyz", null)
    val address = company.address ?: fail("No address")
    println(address.city)

    // Example 3 error function from Kotlin
    error("error")
}