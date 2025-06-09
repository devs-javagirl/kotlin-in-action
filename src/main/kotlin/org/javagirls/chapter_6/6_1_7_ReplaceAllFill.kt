package org.javagirls.chapter_6

fun main() {
    val names = mutableListOf("Martin", "Samuel")
    println(names)

    names.replaceAll { it.uppercase() }
    println(names)

    names.fill("(redacted)")
    println(names)
}