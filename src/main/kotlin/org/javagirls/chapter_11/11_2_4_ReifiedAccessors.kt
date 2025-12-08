package org.javagirls.chapter_11

import java.math.BigInteger


// ------------------------------------------------------------
    // 1) Declaração do accessor reified (igual ao livro)
    // ------------------------------------------------------------
    inline val <reified T> T.canonical: String
        get() = T::class.java.canonicalName

    // ------------------------------------------------------------
    // 2) Versão mais avançada: nome simples e nome completo
    // ------------------------------------------------------------
    inline val <reified T> T.simple: String
        get() = T::class.java.simpleName

    inline val <reified T> T.packageName: String
        get() = T::class.java.`package`?.name ?: "<no-package>"

    // ------------------------------------------------------------
    // 3) Main para testar tudo
    // ------------------------------------------------------------
    fun main() {

        String.canonical
        Boolean.canonical
        println("===== 1) Testes iguais ao livro =====")
        println(listOf(1, 2, 3).canonical)   // java.util.List
        println(1.canonical)                 // java.lang.Integer

        println("\n===== 2) Testes adicionais =====")
        println("Nome simples da lista: ${listOf(1,2,3).simple}")
        println("Nome simples do Int: ${1.simple}")

        println("\n===== 3) Package =====")
        println("Pacote List: ${listOf(1).packageName}")
        println("Pacote Int: ${1.packageName}")
    }

