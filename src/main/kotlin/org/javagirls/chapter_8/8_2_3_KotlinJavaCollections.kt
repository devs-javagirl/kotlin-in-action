package org.javagirls.chapter_8

fun printInUppercase(list: List<String>) {
    // Java modifica a coleção, mesma ela tendo sido declarada como read-only
    println("uppercase list -> ${CollectionUtils.uppercaseAll(list)}")
    println(list.first())
}

fun main() {
    val list = listOf("a", "b", "c")
    println("original list -> $list")
    printInUppercase(list)

}