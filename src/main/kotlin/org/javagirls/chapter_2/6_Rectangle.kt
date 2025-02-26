package org.javagirls.chapter_2

class Rectangle(val height: Int, val width: Int) {
    // custom get
    val isSquare: Boolean
        get() {
            return height == width
        }

    val description: String
        get() {
            if (isSquare)
                return "é um quadrado"
            else
                return "é um retângulo"

        }
}

fun main() {
    val rectangle = Rectangle(41, 43)
    println(rectangle.isSquare)
    println(rectangle.description)

}