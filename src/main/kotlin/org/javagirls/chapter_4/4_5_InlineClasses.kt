package org.javagirls.chapter_4

class UsdCent(val amount: Int)

@JvmInline
value class UsdCentInline(val amount: Int)

fun addExpense(expense: UsdCent) {
    println("expense $expense")
}

fun addExpense(expense: UsdCentInline) {
    println("expense inline $expense")
}

interface PrettyPrintable {
    fun prettyPrint()
}

@JvmInline
value class UsdCents(val amount: Int): PrettyPrintable {
    val salesTax get() = amount * 0.06
    override fun prettyPrint() = println("${amount}c")
}

fun main() {
    addExpense(UsdCent(147))
    addExpense(UsdCentInline(120))

    val expense = UsdCents(199)
    println(expense.salesTax)
    expense.prettyPrint()
}