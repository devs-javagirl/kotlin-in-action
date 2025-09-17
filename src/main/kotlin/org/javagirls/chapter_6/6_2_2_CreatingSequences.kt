package org.javagirls.chapter_6

import java.io.File

fun naturalNumbersSum() {
    val naturalNumbers = generateSequence(0) { it + 1 }
    val numbersTo100 = naturalNumbers.takeWhile { it <= 5 }
    println(numbersTo100.sum())
}

fun File.isInsideHiddenDirectory() = generateSequence(this) {
    it.parentFile}.any { it.isHidden }


fun main() {
    naturalNumbersSum()

    val fileHidden = File("C:\\Users\\Default\\Desktop")
    println(fileHidden.isInsideHiddenDirectory())

    val file = File("C:\\Users\\Public\\Libraries")
    println(file.isInsideHiddenDirectory())
}
