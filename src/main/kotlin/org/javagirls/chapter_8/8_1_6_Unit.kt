package org.javagirls.chapter_8

fun f1(): Unit = println("não faz nada 1")
fun f2() = println("não faz nada 2")

interface Processor<T> {
    fun process(): T
}

class noResultProcessor: Processor<Unit> {
    override fun process() {
        println("override sem necessidade de return")
    }
}

fun main() {
    f1()
    f2()

    val x = noResultProcessor()
    x.process()
}