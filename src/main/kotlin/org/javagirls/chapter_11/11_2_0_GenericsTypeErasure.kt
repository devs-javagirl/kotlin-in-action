package org.javagirls.chapter_11

    // ------------------------------------------------------------
    // 1) Quando o tipo é conhecido (Collection<Int>) os checks são permitidos
    // ------------------------------------------------------------
    fun printSumKnownType(c: Collection<Int>) {
        when (c) {
            is List<Int> -> println("List sum = ${c.sum()}")
            is Set<Int> -> println("Set sum = ${c.sum()}")
        }
    }

    // ------------------------------------------------------------
    // 2) Cast inseguro com generics (unchecked cast)
    // ------------------------------------------------------------
    fun printSumUnknown(c: Collection<*>) {
        val intList = c as? List<Int>
            ?: throw IllegalArgumentException("List<Int> expected")

        println("Sum = ${intList.sum()}")
    }

    // ------------------------------------------------------------
    // 3) Uso de star projection para checar apenas o tipo List
    // ------------------------------------------------------------
    fun printListGeneric(l: List<*>) {
        when (l) {
            is List<*> -> println("É uma lista, mas não sabemos o tipo dos elementos.")
        }
    }

    // ------------------------------------------------------------
    // 4) Exemplo clássico de crash devido a type erasure
    // ------------------------------------------------------------
    fun printSumErasureIssue() {
        val wrong = listOf("a", "b", "c")

        // compila, mas explode em runtime
        printSumUnknown(wrong)
    }

    // ------------------------------------------------------------
    // 5) Funções do texto do livro:
    // readNumbersOrWords() → pode retornar lista de Strings ou Ints
    // ------------------------------------------------------------
    fun readNumbersOrWords(input: String): List<Any> {
        val words = input.split(",")

        val numbers = words.mapNotNull { it.toIntOrNull() }
        return if (numbers.isNotEmpty()) numbers else words
    }

    fun printListErased(l: List<Any>) {
        when (l) {
        //    is List<String> -> println("Strings: $l") // não compila (apagamento de tipo)
        //    is List<Int> -> println("Integers: $l")  // não compila
        }
    }

    // ------------------------------------------------------------
    // 6) Função main com todos os testes
    // ------------------------------------------------------------
    fun main() {

        println("===== 1) Check com tipo conhecido =====")
        printSumKnownType(listOf(1, 2, 3))
        printSumKnownType(setOf(3, 4, 5))

        println("\n===== 2) Unchecked cast =====")
        try {
            printSumUnknown(listOf(1, 2, 3))
        } catch (e: Exception) {
            println("Erro: ${e.message}")
        }

        println("\n===== 3) Unchecked cast com tipo errado =====")
        try {
            printSumUnknown(listOf("a", "b"))
        } catch (e: Exception) {
            println("ClassCastException esperado: $e")
        }

        println("\n===== 4) Star projection =====")
        printListGeneric(listOf("a", "b"))
        printListGeneric(listOf(1, 2, 3))

        println("\n===== 5) Type erasure – listas parecem iguais =====")
        val list1: List<String> = listOf("a", "b")
        val list2: List<Int> = listOf(1, 2, 3)
        println("Ambas são List em runtime: ${list1::class}, ${list2::class}")

        println("\n===== 6) Tentativa de checar List<String> =====")
        // A função abaixo NÃO compila pois os checks são proibidos:
        // printListErased(list1)

        println("\n===== 7) readNumbersOrWords =====")
        val r1 = readNumbersOrWords("1,2,3")
        val r2 = readNumbersOrWords("a,b,c")
        println("Retorno números: $r1")
        println("Retorno strings: $r2")
    }

