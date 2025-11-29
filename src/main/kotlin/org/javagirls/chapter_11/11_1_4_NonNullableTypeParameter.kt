package org.javagirls.chapter_11

class Processor<T> {
    fun process(value: T) {
        println(value?.hashCode())
    }
}

class ProcessorNonNull<T : Number> {
    fun process(value: T) {
        println(value.hashCode())
    }
}
fun main() {
    val nullableStringProcessor = Processor<kotlin.String?>()
    nullableStringProcessor.process(null)

    val nonNullStringProcessor = ProcessorNonNull<Number>()
    nonNullStringProcessor.process(Integer.MIN_VALUE)
}
