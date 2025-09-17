package org.javagirls.chapter_9

class Point1(val x: Int, val y: Int) {
    override fun equals(other: Any?): Boolean {
        if (other === this) return true
        if (other !is Point1) return false
        return other.x == x && other.y == y
    }

    override fun hashCode(): Int {
        var result = x
        result = 31 * result + y
        return result
    }
}

fun main() {
    println(Point1(10, 20) == Point1(10, 20))
    println(Point1(10, 20) != Point1(5, 5))
    println(null == Point1(1, 2))

    val x = Point(35, 45)
    val y = x
    println(x === y)

}
