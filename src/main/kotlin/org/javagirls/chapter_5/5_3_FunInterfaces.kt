package org.javagirls.chapter_5

fun interface IntCondition {
    // abstract method
    fun check(i: Int): Boolean
    // non abstract method
    fun checkString(s: String) = check(s.toInt())
    fun checkChar(c: Char) = check(c.digitToInt())
}

fun checkCondition(i: Int, condition: IntCondition): Boolean {
    return condition.check(i)
}

fun main() {
    val isOdd = IntCondition { it % 2 != 0}
    println(isOdd.check(1))

    println(isOdd.checkString("2"))

    println(isOdd.checkChar('3'))

    // se a lambda for o último argumento da função, ela pode ser colocada fora dos parênteses
    println(checkCondition(1) { it % 2 != 0})
    println(checkCondition(1, { it % 2 != 0}))

    // definindo uma lambda com a mesma assinatura da interface IntCondition
    val isOdd2: (Int) -> Boolean = { it % 2 != 0 }
    println(checkCondition(1, isOdd2))

}

