package org.javagirls.coroutines

import kotlinx.coroutines.*
import kotlin.coroutines.coroutineContext

suspend fun introspect() {
    log(coroutineContext)
}

fun main() {
    runBlocking (CoroutineName("SomeWork")) {
        log("Doing some work")
        introspect()

        launch(Dispatchers.IO + CoroutineName("Background")) {
            log("Doing some work in the background")
            introspect()
        }
    }

}