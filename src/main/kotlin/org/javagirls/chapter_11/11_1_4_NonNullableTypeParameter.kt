package org.javagirls.chapter_11

class Processor<T> {
    fun process(value: T) {
        println(value?.hashCode())
    }
}

class ProcessorNonNull<T : Any> {
    fun process(value: T) {
        println(value.hashCode())
    }
}
fun main() {
    val nullableStringProcessor = Processor<kotlin.String?>()
    nullableStringProcessor.process(null)

    val nonNullStringProcessor = ProcessorNonNull<kotlin.String>()
    nonNullStringProcessor.process("test")
}