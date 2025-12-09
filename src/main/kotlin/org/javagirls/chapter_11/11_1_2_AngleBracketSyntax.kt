package org.javagirls.chapter_11

abstract class StringList: List<String> {
    override fun get(index: Int): String = this.get(index)
}

abstract class ArrayList<T>: List<T> {
    override fun get(index: Int): T = this.get(index)
}

interface Comparable<T> {
    operator fun compareTo(other: T): Int
}

fun main() {
    //criar lista de strings e comparar dois elementos
    val amigas: List<String> = listOf("Cris", "Bruna", "Gabi")

    //percorra a lista e compare se as amigas são igual a "Cris"
    val resultado = amigas[0].compareTo("Cris")

    println("Resultado da comparação: $resultado")

}
