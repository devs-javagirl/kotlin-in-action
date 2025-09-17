package org.javagirls.chapter_8

fun main() {
    alphabet()
    alphabetWithComma()
    listToArray()
    fiveZeros()
    squares()
}

fun alphabet() {
    val letters = Array<String>(26) {
            i -> ('a' + i).toString()
    }

    println(letters.joinToString("-"))
}

fun alphabetWithComma() {
    val letters = Array(26) {
        i -> ('a' + i).toString()
    }
    println(letters.joinToString())
}

fun listToArray() {
    val strings = listOf("a", "b", "c")
    println("%s%s%s".format(*strings.toTypedArray()))
}

fun fiveZeros() {
    val fiveZeros = IntArray(5)
    val fiveZerosToo = intArrayOf(0, 0, 0, 0, 0)

    println("fiveZeros -> ${fiveZeros.get(0)}")
    println("fiveZerosToo -> ${fiveZerosToo.get(1)}")
}

fun squares() {
    val squares = IntArray(5) { i -> (i+1) * (i+1)}
    println("squares -> ${squares.joinToString()}")
}

