package org.javagirls.chapter_9

import java.time.LocalDate

//adiciona um iterator para ClosedRange<LocalDate>, usando Extension Functions
//implementa a interface Iterator<LocalDate> e sobrescreve os métodos hasNext e next
operator fun ClosedRange<LocalDate>.iterator(): Iterator<LocalDate> =
    object: Iterator<LocalDate> {
        var current = start

        override fun hasNext() =
            current <= endInclusive

        override fun next(): LocalDate {
            val thisDate = current
            current = current.plusDays(1)
            return thisDate

        }
    }

fun main() {
    for (c in "abc") {
        println(c)
    }

    val newYear = LocalDate.ofYearDay(2042,1)
    println(newYear)
    val daysOff = newYear.minusDays(2)..newYear
    println(daysOff)

    for (dayOff in daysOff) { println(dayOff) }

}