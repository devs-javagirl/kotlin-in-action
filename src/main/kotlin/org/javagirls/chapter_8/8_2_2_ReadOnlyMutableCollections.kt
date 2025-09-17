package org.javagirls.chapter_8

fun <T> copyElements(source: Collection<T>,
                     target: MutableCollection<T>) {
    for (item in source) {
        target.add(item)
    }
}

fun main() {
    // Example 1
    val source: Collection<Int> = arrayListOf(3, 5, 7)
    val target: MutableCollection<Int> = arrayListOf(1)

    copyElements(source, target)
    println(target)

    // Example 2
    val source1: Collection<Int> = arrayListOf(3, 5, 7)
    val target1: Collection<Int> = arrayListOf(1)
    //copyElements(source1, target1)

    // Example 3 - referência mutável e read-only apontando para a mesma coleção, permite alterações
    val mutableList = mutableListOf(1, 2, 3) // Mutable reference
    val readOnlyList: List<Int> = mutableList // Read-only reference

    println(readOnlyList) // [1, 2, 3]
    mutableList.add(4)
    mutableList.add(4)
    println(readOnlyList) // [1, 2, 3, 4]

}
