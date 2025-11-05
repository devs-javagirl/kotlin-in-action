package org.javagirls.chapter_10

import java.io.BufferedReader
import java.io.FileReader
import java.util.concurrent.locks.Lock

inline fun <T> Lock.withLock(action: () -> T): T {
    lock()
    try {
        return action()
    } finally {
        unlock()
    }
}

fun readFirstLineFromFile(fileName: String): String {
    BufferedReader(FileReader(fileName)).use {
        br -> return br.readLine()
    }
}



fun main() {
    val fakeLock = FakeLock()
    fakeLock.withLock {
        println("fake lock withLock")
    }

    println(readFirstLineFromFile("src/main/resources/TestFile"))
}