package org.javagirls.chapter_5

// usar apply sempre retorna o objeto que foi passado como argumento, no caso StringBuilder
fun alphabetApply() = StringBuilder().apply {
    for (letter in 'A'..'Z') {
        append(letter)
    }
    append("\nNow I know the alphabet")
}.toString()

// o argumento da função buildString é uma lambda cujo receiver é um StringBuilder
fun alphabetBuildString() = buildString {
    for (letter in 'A'..'Z') {
        append(letter)
    }
    append("\nNow I know the alphabet")
}

// Kotlin tem funções builder que tratam List, Set, Map como read only, permitindo usá-las como mutable
// durante a fase de construção
val fibonnaci = buildList {
    addAll(listOf(1, 1, 2))
    add(3)
    add(index = 0, element = 3)
}

val shouldAdd = true

val fruits = buildSet {
    add("Apple")
    if(shouldAdd) {
        addAll(listOf("Apple", "Banana", "Cherry"))
    }
}

val medals = buildMap<String, Int> {
    put("Gold", 1)
    putAll(listOf("Silver" to 2, "Bronze" to 3))
}

fun main() {
    println(alphabetApply())
    println(alphabetBuildString())

    println(fibonnaci)
    println(fruits)
    println(medals)
}