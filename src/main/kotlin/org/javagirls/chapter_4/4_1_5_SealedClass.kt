package org.javagirls.chapter_4

sealed class Expr

class Num(val value: Int): Expr()
class Sum(val left: Expr, val right: Expr): Expr()

fun eval(e: Expr): Int =
    when (e) {
        is Num -> e.value
        is Sum -> eval(e.right) + eval(e.left)
    }

fun main() {
    println(eval(Num(4)))
    println(eval(Sum(Num(1), Num(2))))
}