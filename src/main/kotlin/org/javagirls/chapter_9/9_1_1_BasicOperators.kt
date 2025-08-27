package org.javagirls.chapter_9

data class Point(val x: Int, val y: Int) {
    operator fun plus(other: Point): Point {
        return (Point(x + other.x, y + other.y))
    }
}

// Extension function
operator fun Point.minus(other: Point): Point {
    return Point(x - other.x, y - other.y)
}

operator fun Point.times(scale: Double): Point {
    return Point((x * scale).toInt(), (y * scale).toInt())
}

operator fun Char.times(count: Int): String {
    return toString().repeat(count)
}

fun main() {
    val p1 = Point(10, 20)
    val p2 = Point(30, 40)

    println("plus operator -> ${p1 + p2}")

    println("minus operator -> ${p2 - p1}")

    println("times operator -> ${p1 * 1.5}")

    println("times with char -> ${'a' * 3}")

}