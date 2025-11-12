package org.javagirls.chapter_11

import kotlin.Comparable

//fun <T: Number> List<T>.sum(): T

fun <T: Number> oneHalf(value: T): Double {
    return value.toDouble() / 2.0
}

fun <T: Comparable<T>> max(first: T, second: T): T {
    return if (first > second) first else second
}

fun <T> ensureTrailingPeriod(seq: T)
    where T: CharSequence, T: Appendable {
        if (!seq.endsWith('.')) {
            seq.append('.')
        }
    }

fun main() {
    println(listOf(1, 2, 3).sum())
    println(oneHalf(3))

    println(max("kotlin", "java"))
    println(max(9L, 10L))
    //println(max("kotlin", 42))

    val helloWorld = StringBuilder("Hello World")
    ensureTrailingPeriod(helloWorld)
    println(helloWorld)
}