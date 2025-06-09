package org.javagirls.chapter_6

fun ifEmpty() {
    val empty = emptyList<String>()
    val full = listOf("apple", "orange", "banana")

    println(empty.ifEmpty { listOf("no", "values", "here") })

    println(full.ifEmpty { listOf("no", "values", "here")})
}

fun ifBlank() {
    val blankName = " "
    val name = "J. Doe"

    println(blankName.ifEmpty { "ifEmpty --> (unnamed)" })
    println(blankName.ifBlank { "ifBlank --> (unnamed)" })
    println(name.ifBlank { "ifBlank --> (unnamed)" })
}
fun main() {
    ifEmpty()
    ifBlank()
}