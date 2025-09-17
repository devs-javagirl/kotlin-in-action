package org.javagirls.chapter_8

fun main() {
    val answer1: Any? = 42
    val answer2: Any? = 42L
    val answer3: Any? = "test"

    println("42 = ${answer1?.javaClass}")
    println("42L = ${answer2?.javaClass}")
    println("test = ${answer3?.javaClass}")

    val answer4 = 42 as Object
    println("42 = ${answer4.javaClass}")

    synchronized(answer4) {
        answer4.wait(4000)
    }

    // without synchronized -> IllegalMonitorStateException - current thread is not owner"
    // The wait() method in Java/Kotlin is a method of Object.
    // You can only call wait() on an object if the current thread owns the monitor for that object.
    // You own the monitor if you are inside a synchronized block for that object.

    println("Object wait 4000 miliseconds $answer4")
}
