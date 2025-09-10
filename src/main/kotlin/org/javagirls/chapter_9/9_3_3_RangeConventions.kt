package org.javagirls.chapter_9

import java.time.LocalDate

fun rangeWithDays() {
    val now = LocalDate.now()

    val vacation = now..now.plusDays(10)
    println(now.plusWeeks(1) in vacation)

    val vacation1 = now.rangeTo(now.plusDays(10))
    println(now.plusWeeks(1) in vacation1)

    val vacation2 = now.rangeTo(now.plusDays(10))
    println(vacation2.start)
    println(vacation2.endInclusive)
    println("rangeTo -> ${LocalDate.of(2025, 9, 19) in vacation2}")

    val vacation3 = now.rangeUntil(now.plusDays(10))
    println(vacation3.start)
    println(vacation3.endExclusive)
    println("rangeUntil -> ${LocalDate.of(2025, 9, 19) in vacation3}")

}

fun rangeWithAritmeticOperators() {
    val n = 9
    println("rangeWithAritmeticOperators")
    println(0..(n+1))
    println()

}

fun rangeForEach() {
    val n = 9
    println("rangeForEach")
    (0..n).forEach { print(it) }
    println()
}

fun rangeUntil() {
    println("rangeUntil")
    (0..<9).forEach { print(it)}
}

fun main() {
    rangeWithDays()

    rangeWithAritmeticOperators()

    rangeForEach()

    rangeUntil()
}

