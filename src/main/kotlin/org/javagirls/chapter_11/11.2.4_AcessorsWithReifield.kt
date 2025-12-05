package org.javagirls.chapter_11

class Exercise_11_2_4 {

    // Propriedade reified igual ao livro
    inline val <reified T> T.canonical: String
        get() = T::class.java.canonicalName


}

fun main() {
    println("=== Exercício 11.2.4 ===")

    // Exemplo 1: lista
    val list = listOf(1, 2, 3)
    println(list.canonical)        // java.util.List

    // Exemplo 2: inteiro
    val number = 1
    println(number.canonical)      // java.lang.Integer
}
