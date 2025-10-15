package org.javagirls.chapter_10

fun processTheAnswer(f: Function1<Int, Int>) {
    println(f.invoke(42))
}

class Adder: (Int, Int) -> Int {
    override operator fun invoke(
        p1: Int,
        p2: Int
    ): Int {
        return p1 + p2
    }
}

class AdderUnderHood: Function2<Int, Int, Int> {
    override fun invoke(p1: Int, p2: Int): Int {
        return p1 + p2
    }
}


fun main() {
    processTheAnswer { num -> num + 1 }

    val adder = Adder()
    println(adder.invoke(2, 3))

    val adderUnderHood = AdderUnderHood()
    println(adderUnderHood.invoke(2, 3))
}