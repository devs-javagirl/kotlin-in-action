package org.javagirls.chapter_8

fun main() {
    val uByte: UByte = 4u
    val byte: Byte = -126

    val uLong: ULong
    uLong = 4u

    println("UByte $uByte")
    println("uByte bits ${uByte.toBitString()}")
    println("Byte $byte")
    println("Byte bit ${byte.toBitString()}")

    println("UByte MAX_VALUE ${UByte.MAX_VALUE}")
    println("UByte MAX_VALUE ${UByte.MIN_VALUE}")

    println("Byte MAX_VALUE ${Byte.MAX_VALUE}")
    println("Byte MAX_VALUE ${Byte.MIN_VALUE}")

    println("ULong $uLong")
    println("ULong ${uLong.toBitString()}")


}

fun Byte.toBitString(): String =
    (this.toInt() and 0xFF).toString(2).padStart(8, '0')

fun UByte.toBitString(): String = this.toString(2).padStart(8, '0')

fun ULong.toBitString(): String =
    (this.toInt() and 0xFF).toString(2).padStart(8, '0')