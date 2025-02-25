package org.javagirls.chapter_2

class Rectangle(val height: Int, val width: Int) {
    val isSquare: Boolean
        // custom get
        get() {
            return height == width
        }
}

fun main() {
    val rectangle = Rectangle(41, 43)
    println(rectangle.isSquare)
}