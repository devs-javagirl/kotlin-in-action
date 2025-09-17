package org.javagirls.design_patterns.coroutines

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

private var zeroTime = System.currentTimeMillis()

fun log(message: Any?) =
    println("${System.currentTimeMillis() - zeroTime} " +
    "[${Thread.currentThread().name}] $message")

fun main() = runBlocking {
    log("The first, parent, coroutine starts")
    launch {
        log("The second coroutine starts and is ready to be suspended")
        delay(5000)
        log("The second coroutine is resumed")
    }

    launch {
        log("The third coroutine can run in the meantime")
        delay(5000)
    }

    log("The first coroutine has lauched two more coroutines")
}