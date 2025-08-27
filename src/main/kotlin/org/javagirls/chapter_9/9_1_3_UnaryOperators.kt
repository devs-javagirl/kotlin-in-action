package org.javagirls.chapter_9

import java.math.BigDecimal

operator fun Point.unaryMinus(): Point {
    return Point(-x, -y)
}

operator fun BigDecimal.inc() = this + BigDecimal.ONE

fun main() {
    val p = Point(10, 20)
    println("minus point -> ${-p}")

    var bd = BigDecimal.ZERO
    println("big decimal pos increment -> ${bd++}")

    println("big decimal -> ${bd}")

    println("big decimal pre increment -> ${++bd}")

}