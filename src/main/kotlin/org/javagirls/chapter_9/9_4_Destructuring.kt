package org.javagirls.chapter_9

class PointDestructuring(val x: Int, val y: Int) {
    operator fun component1() = x
    operator fun component2() = y
}

data class NameComponents(val name: String,
    val extension: String)

fun splitFilename(fullName: String): NameComponents {
    val result = fullName.split('.', limit = 2)
    return NameComponents(result[0], result[1])
}

//coleções implementam Destructuring
fun splitFilenameDestructuring(fullName: String): NameComponents {
    val (name, extension) = fullName.split('.', limit = 2)
    return NameComponents(name, extension)
}

fun main() {
    val point = PointDestructuring(5, 40)
    val (x, y) = point
    println(x)
    println(y)

    val (name, ext) = splitFilename("example.txt")
    println("splitFilename file: $name")
    println("splitFilename extension: $ext")

    val (name1, ext1) = splitFilenameDestructuring("example.txt")
    println("splitFilenameDestructuring file: $name1")
    println("splitFilenameDestructuring extension:$ext1")

    val pair = Pair("StackSpot", 2024)
    println("pair.first ${pair.first}")  // Output: StackSpot
    println("pair.second ${pair.second}") // Output: 2024

    val (app, year) = Pair("StackSpot", 2024)
    println(app) // Output: StackSpot
    println(year) // Output: 2024
}