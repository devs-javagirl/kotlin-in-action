package org.javagirls.chapter_10

class FunctionStore {
    var myStoredFunction: ((Int) -> Unit) ? = null
    //inline fun storeFunction(f: (Int) -> Unit) {
    fun storeFunction(f: (Int) -> Unit) {
        println("inline doesn't accept storing values")
        myStoredFunction = f
        myStoredFunction!!.invoke(3)

    }
}

fun <T, R> Sequence<T>.map(transform: (T) -> R): Sequence<R> {
    return TransformingSequence(this, transform)
}

class TransformingSequence<T, R>(
    private val sequence: Sequence<T>,
    private val transform: (T) -> R
) : Sequence<R> {

    override fun iterator(): Iterator<R> {
        TODO("Not yet implemented")
    }

}

inline fun foo(inlined: () -> Unit, noinline notInlined: () -> Unit) {

}

fun main() {
    val functionStore = FunctionStore()
    functionStore.storeFunction { x -> println("the value is $x") }
}