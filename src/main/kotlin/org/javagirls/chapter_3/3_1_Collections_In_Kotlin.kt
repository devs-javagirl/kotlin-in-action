package org.javagirls.chapter_3

class `3_1_Collections_In_Kotlin` {
    val set = setOf(1, 7, 53)
    val list = listOf(1, 7, 53)
    val map = mapOf(1 to "one", 7 to "seven", 53 to "fifty-three")

    fun collections() {

        println(" *********************** ")
        println()

        println("Set: " + set.javaClass)
        println("List: " + list.javaClass)
        println("Map: " + map.javaClass)

        println()
        println(" *********************** ")
        println()

        println(set)
        println(list)
        println(map)
    }
}

fun main() {
    val collections = `3_1_Collections_In_Kotlin`()
    collections.collections()
}

fun Car(){
    val cor = ""

    fun acelerar(){
        println("Acelerando")
    }
}