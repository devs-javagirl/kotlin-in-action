package org.javagirls.chapter_9


operator fun Point.get(index: Int): Int{
    return when(index) {
        0 -> x
        1 -> y
        else ->
            throw IndexOutOfBoundsException("Invalid coordinate $index")
    }
}

data class MutablePoint(var x: Int, var y: Int)

operator fun MutablePoint.set(index: Int, value: Int) {
    when(index) {
        0 -> x = value
        1 -> y = value
        else ->
            throw IndexOutOfBoundsException("Invalid coordinate $index")
    }
}

fun main() {
    val p = Point(10, 20)
    println(p[0])
    println(p[1])

    val pm = MutablePoint(15, 25)
    println(pm)

    pm[0] = 42
    pm[1] = 22
    println(pm)
}