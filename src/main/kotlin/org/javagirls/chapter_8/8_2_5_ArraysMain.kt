package org.javagirls.chapter_8

fun main(args: Array<String>) {
    for (i in args.indices) {
        println("Argument $i is: ${args[i]}")
    }

    args.forEachIndexed {
        index, element -> println("Argument $index is : $element")
    }
}

