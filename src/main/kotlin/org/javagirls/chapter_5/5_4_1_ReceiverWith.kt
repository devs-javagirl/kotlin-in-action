package org.javagirls.chapter_5

fun alphabet(): String {
    val result = StringBuilder()
    for (letter in 'A'..'Z') {
        result.append(letter)
    }
    result.append("\nNow I know the alphabet")
    return result.toString()
}

fun alphabetWith(): String {
    val stringBuilder = StringBuilder()

    return with(stringBuilder) {
        for (letter in 'A'..'Z') {
            this.append(letter)
        }
        this.append("\nNow I know the alphabet")
        this.toString()
    }
}

fun alphabetWithoutThis(): String {
    val stringBuilder = StringBuilder()
    return with(stringBuilder) {
        for (letter in 'A'..'Z') {
            append(letter)
        }
        append("\nNow I know the alphabet")
        toString()
    }
}


fun alphabetExprBody() = with(StringBuilder()) {
    for (letter in 'A'..'Z') {
        append(letter)
    }
    append("\nNow I know the alphabet")
    toString()
}

fun main() {
    println(alphabet())
    println(alphabetWith())
    println(alphabetWithoutThis())
    println(alphabetExprBody())
}