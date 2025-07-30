package org.javagirls.chapter_8

fun readNumbers(text: String): List<Int?> {
    val result = mutableListOf<Int?>()

    for (line in text.lineSequence()) {
        val numberOrNull = line.toIntOrNull()
        result.add(numberOrNull)
    }

    return result
}

fun readNumbers2(text: String): List<Int?> =
    text.lineSequence().map {
        it.toIntOrNull()
    }.toList()

fun addValidNumbers(numbers: List<Int?>) {
    var sumOfValidNumbers = 0
    var invalidNumbers = 0

    for (number in numbers) {
        if (number != null) {
            sumOfValidNumbers += number
        } else {
            invalidNumbers++
        }
    }

    println("Sum of valid numbers: $sumOfValidNumbers")
    println("Invalid numbers: $invalidNumbers")
}

fun addValidNumbers2(numbers: List<Int?>) {
    val validNumbers = numbers.filterNotNull()
    println("Sum of valid numbers: ${validNumbers.sum()}")
    println("Invalid numbers: ${numbers.size - validNumbers.size}")
}

fun main() {
    val input = """
        1
        abc
        42
    """.trimIndent()

    // Example 1
    val numbers1 = readNumbers(input)
    addValidNumbers(numbers1)

    // Example 2
    val numbers2 = readNumbers2(input)
    addValidNumbers(numbers2)

    // Example 3
    addValidNumbers2(numbers1)

}