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
    println("UByte MIN_VALUE ${UByte.MIN_VALUE}")

    println("Byte MAX_VALUE ${Byte.MAX_VALUE}")
    println("Byte MIN_VALUE ${Byte.MIN_VALUE}")

    println("ULong $uLong")
    println("ULong bits ${uLong.toBitString()}")

    println("ULong MAX_VALUE ${ULong.MAX_VALUE}")
    println("ULong MIN_VALUE ${ULong.MIN_VALUE}")


}

fun Byte.toBitString(): String =
    (this.toInt() and 0xFF).toString(2).padStart(8, '0')

fun UByte.toBitString(): String = this.toString(2).padStart(8, '0')

fun ULong.toBitString(): String =
    this.toString(2).padStart(64, '0')
