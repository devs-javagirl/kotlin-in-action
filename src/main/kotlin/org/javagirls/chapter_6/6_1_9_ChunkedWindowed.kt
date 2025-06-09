package org.javagirls.chapter_6

val temperatures = listOf( 27.7, 29.8, 22.0, 35.5, 19.1)

fun windowed() {
    println("windowed --> ${temperatures.windowed(3)}")
    println(temperatures.windowed(3) { it.sum() / it.size })
}

fun chunked() {
    println("chunked --> ${temperatures.chunked(2)}")
    println(temperatures.chunked(2) { it.sum() })
}
fun main() {
    windowed()
    chunked()
}