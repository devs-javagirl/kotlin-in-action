package org.javagirls.chapter_5

fun interface StringConsumer {
    fun consume(s: String)
}

// função utilizando functional interface
fun consumeHello(t: StringConsumer) {
    t.consume("Hello")
}

// função utilizando functional type
fun consumeHelloFunctional(t: (String) -> Unit) {
    t("Hello")
}

fun main() {
    consumeHello({ s -> println(s.uppercase())})
    consumeHelloFunctional({ s -> println(s.uppercase())})
}