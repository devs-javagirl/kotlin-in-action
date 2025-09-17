package org.javagirls.chapter_7

// não permite que s seja null
fun strLen(s: String) = s.length

// s pode conter null
fun strLenSafe(s: String?): Int = if (s != null) s.length else 0

fun main() {
    println(strLen("test"))
    //strLen(null)

    val x: String? = null
    println(strLenSafe(x))
    println(strLenSafe("abc"))
}
