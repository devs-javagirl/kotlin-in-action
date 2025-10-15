package org.javagirls.chapter_10

import kotlin.jvm.functions.FunctionN

fun twoAndThree(operation: (Int, Int) -> Int) {
    val result = operation(2, 3)
    println("The result is $result")
}

fun twoAndThreeDetailed( operation: (operandA: Int, operandB: Int) ->  Int) {
    val result = operation(2, 3)
    println("The result is $result")

}

fun String.filter(predicate: (Char) -> Boolean): String {
    return buildString {
        for (char in this@filter) {
            if (predicate(char)) append(char)
        }
    }
}

fun main() {
    println("sum twoAndThree operation")
    twoAndThree { a, b -> a + b }

    println("multiply twoAndThree operation")
    twoAndThree { a, b -> a * b }

    println("twoAndThreeDetailed operation")
    twoAndThreeDetailed { operandA, operandB -> operandA + operandB }

    println("twoAndThreeDetailed operation")
    twoAndThreeDetailed { alpha, beta -> alpha + beta }

    println("abc".filter { it in 'a'..'z'})

}