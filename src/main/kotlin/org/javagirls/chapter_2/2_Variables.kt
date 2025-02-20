package org.javagirls.chapter_2

fun main() {
    println("KOTLIN --------------------------")
    // val = value ( read only )
    // val nomeVariavel | tipo | valor
    val question: String = "The Ultimate Question of Life, the Universe, and Everything"
    println(question)

    val answer: Int = 42
    println(answer)

    val yearsToCompute = 7.5e6 // Double or floating point
    println(yearsToCompute)

    // declaração da variável e atribuição na sequência
    val answerDeclaration: Int
    answerDeclaration = 42
    println(answerDeclaration)

    // language é imutável, mas aponta para uma variável mutável ( mutableListOf )
    val languages = mutableListOf("Java")
    languages.add("Kotlin")
    languages.add("Python")
    println(languages)


    val result: String
    if (canPerformOperation()) {
        result = "Success"
    } else {
        result = "Can't perform operation"
    }
    println(result)

    // var = variable ( pode ser atribuído novo valor )
    var answerVar = 42
    answerVar = 45

    println(answerVar)

}

fun canPerformOperation(): Boolean {
    return true
}