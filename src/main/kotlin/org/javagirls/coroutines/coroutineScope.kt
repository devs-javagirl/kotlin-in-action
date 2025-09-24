package org.javagirls.coroutines

import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.coroutines.coroutineContext
import kotlin.random.Random

suspend fun generateValue(): Int {
    delay(500)
    return Random.nextInt(0, 10)
}

suspend fun computeSum() {
    log("Computing a sum ...")

    val sum = coroutineScope {
        log("Scope context: $coroutineContext")
        log("Scope Job: $coroutineContext.job")

        val a = async { generateValue() }
        val b = async { generateValue() }

        val aValue = a.await()
        val bValue = b.await()

        log(aValue)
        log(bValue)

        aValue + bValue
    }
    log(coroutineContext)
    log("Sum is $sum")
}

fun main() = runBlocking {
    log("starting compute")
    computeSum()
}