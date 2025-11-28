package org.javagirls.chapter_11

//fun <T> isA(value: Any) = value is T
//Cannot check for instance of erased type: T

inline fun <reified T> isA(value: Any) = value is T

fun main() {
    println(isA<kotlin.String>("abc"))
    println(isA<kotlin.String>(123))
    println(isA<Int>(123))

    val items = listOf("one", 2, "three")
    println(items.filterIsInstance<kotlin.String>())

    println(items.filterIsInstance2<Int>())
    
}

inline fun <reified T> Iterable<*>.filterIsInstance2(): List<T> {
    val destination = mutableListOf<T>()
    for ( element in this) {
        if (element is T) {
            destination.add(element)
        }
    }
    return destination
}