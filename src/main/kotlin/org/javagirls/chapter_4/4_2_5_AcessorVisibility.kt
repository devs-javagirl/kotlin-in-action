package org.javagirls.chapter_4

class LengthCounter {
    var counter: Int = 0
    private set

    fun addWord(word: String) {
        counter += word.length
    }
}

fun main() {
    val lengthCounter = LengthCounter()
    lengthCounter.addWord("Hi!")
    println(lengthCounter.counter)
    // não é possível alterar valor de counter pois ele é private
    // lengthCounter.counter = 0

}
