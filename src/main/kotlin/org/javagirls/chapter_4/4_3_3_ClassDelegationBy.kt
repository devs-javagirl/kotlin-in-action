package org.javagirls.chapter_4

class DelegatingCollection<T>(
    private val innerList: Collection<T> = ArrayList<T>()
) : Collection<T> by innerList {

    fun printAllElements() {
        println("Elementos da coleção:")
        for (element in innerList) {
            println(element)
        }
    }
}

fun main() {
    val myList = listOf("Kotlin", "Java", "Python")
    val delegating = DelegatingCollection(myList)
    println("Tamanho: ${delegating.size}")
    delegating.printAllElements()   // Método adicional
    println("Está vazia? ${delegating.isEmpty()}")

    val cset = CountingSet<Int>()
    cset.addAll(listOf(1,1,2))
    cset.addAll(listOf(3,4,5))
    println("Adicionadas: ${cset.objectsAdded} objects, ${cset.size} uniques. ") // Contagem de adições

}

class CountingSet<T>(
    // Usando MutableSet<T> para permitir modificações
    private val innerSet: MutableSet<T> = mutableSetOf()
) : MutableSet<T> by innerSet {

    var objectsAdded = 0
    override fun add(element: T): Boolean {
        objectsAdded++
        return innerSet.add(element)
    }
    override fun addAll(elements: Collection<T>): Boolean {
        objectsAdded += elements.size
        return innerSet.addAll(elements)
    }
}

