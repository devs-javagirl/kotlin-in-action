package org.javagirls.chapter_6

fun ifEmpty() {
    val empty = mutableListOf<String>()
    val full = listOf("apple", "orange", "banana")

    println(empty.ifEmpty {
        empty.add("a")
        empty.add("b")
        empty.add("c")
        empty.toList()
    })
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
