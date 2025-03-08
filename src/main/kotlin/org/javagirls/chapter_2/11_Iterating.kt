package org.javagirls.chapter_2

// iteração numa lista de strings
fun printColors() {
    val collection = listOf("red", "green", "blue")
    for (color in collection) {
        print("$color ")
    }
}

fun mapOfChars() {
    // mutable maps mantém a ordem de inclusão
    val binaryReps = mutableMapOf<Char, String>()

    // faz range de caracteres
    for (char in 'A'..'F') {
        // converte código ASCII para binário
        val binary = char.code.toString(radix = 2)
        // utiliza o caracter como chave e a representação binária como valor
        // equivalente ao put do java
        binaryReps[char] = binary
    }

    // for permite que você leia a coleção no formato kev-value -> letter, binary [destructuring syntax]
    // itera o map imprimindo a chave (letter) e respectivo valor (binary)
    for ((letter, binary) in binaryReps) {
        println("$letter = $binary")
    }
}

fun listOfNumbers() {
    val list = listOf("10", "11", "1001")
    // itera a lista considerando o índice dos elementos (index) e respectivo valor (element
    for ((index, element) in list.withIndex()) {
        println("$index: $element")
    }
}

fun main() {
    println("colors ...............")
    printColors()
    println()

    println("mapOfChars ...............")
    mapOfChars()

    println("listOfNumbers ...............")
    listOfNumbers()
}