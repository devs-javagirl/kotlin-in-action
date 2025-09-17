package org.javagirls.design_patterns.coroutines

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

suspend fun slowlyAddNumbers(a: Int, b: Int): Int {
    val seconds = 1000 * a.toLong()
    log("Waiting ${seconds/1000} seconds before calculating $a + $b")
    delay(seconds)
    return a + b
}

fun main() = runBlocking {
    log("Starting the async computation")
    val myFirstDeferred = async { slowlyAddNumbers(2, 2) }
    val mySecondDeferred = async { slowlyAddNumbers( 4, 4) }

    log("Waiting for the deferred value to be available")
    log("The first result: ${myFirstDeferred.await()}")
    log("The second result: ${mySecondDeferred.await()}")

}