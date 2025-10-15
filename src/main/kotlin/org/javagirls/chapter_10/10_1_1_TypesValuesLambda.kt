package org.javagirls.chapter_10

val sum = { x:Int, y:Int -> x + y }
val action = { println(42) }

val sumIdeDeclaration: (Int, Int) -> Int = { x, y -> x +y }
val actionIdeDeclaration: () -> Unit = { println(42) }

var canReturnNull: (Int, Int) -> Int? = { x, y -> null }
var funOrNull: ((Int, Int) -> Int)? = null

fun main() {
    println("sum: ${sum(2, 3)}")
    action()

    println("sumIdeDeclaration: ${sumIdeDeclaration(2,3)}")
    actionIdeDeclaration()

    println("canReturnNull: ${canReturnNull(2, 3)}")

    println("funOrNull: ${funOrNull?.invoke(2, 3)}")
}