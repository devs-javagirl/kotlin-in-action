package org.javagirls.chapter_7



fun <T> printHashCode(t: T) {
    println(t?.hashCode())
}

fun <T: Any> printHashCodeAny(t: T) {
    println(t.hashCode())
}

fun main() {
    printHashCode(null)
    printHashCode("teste")
    printHashCode(23)

    //printHashCodeAny(null)
    printHashCodeAny("teste")
    printHashCodeAny(23)
}
