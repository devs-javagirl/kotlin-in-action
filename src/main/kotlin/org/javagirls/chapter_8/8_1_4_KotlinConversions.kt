package org.javagirls.chapter_8

fun main() {

    // example 1
    val i = 1
    val l: Long = i.toLong()
    println("l = i: $l")

    // example 2
    val x = 1
    val list = listOf(1L, 2L, 3L)
    //println(x in list)
    println("x in list: ${x.toLong() in list}")

    // example 3
    val b: Byte = 1
    val c = b + 1L
    println("soma de byte + long: $c")

    // example 4
    printALong(42)

    // example 5
    println("conversão string 42: " + "42".toInt())

    // example 6
    println("conversão seven: " + "seven".toIntOrNull())

    // example 7
    println("booleano trUE: " + "trUE".toBoolean())
    println("booleano 7: " + "7".toBoolean())
    println("booleano null: " + null.toBoolean())

    // example 8
    println("booleanStrict true: " + "true".toBooleanStrict())
    println("booleanStrict false: " + "false".toBooleanStrict())

    //println("booleanStrict True: " + "True".toBooleanStrict())
    //IllegalArgumentException

}

fun printALong (l: Long) = println(l)
