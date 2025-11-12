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

class String: Comparable<String> {
    override fun compareTo(other: String): Int = TODO()
}