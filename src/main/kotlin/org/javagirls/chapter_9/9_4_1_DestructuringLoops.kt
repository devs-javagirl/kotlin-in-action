package org.javagirls.chapter_9

fun printEntriesFor(map: Map<String, String>) {
    for((key, value) in map) {
        println("printEntriesFor: $key -> $value")
    }
}

fun printEntriesForEach(map: Map<String, String>) {
    map.forEach { (key, value) ->
        println("printEntriesForEach: $key -> $value")
    }
}

fun main() {
    val map = mapOf("Oracle" to "Java", "JetBrains" to "Kotlin")
    printEntriesFor(map)
    printEntriesForEach(map)
}