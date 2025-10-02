package org.javagirls.coroutines

import kotlinx.coroutines.*

fun main() =
    runBlocking(CoroutineName("A")) {
        log("A's context: ${coroutineContext}")
        log("A's job: ${coroutineContext.job}")
        launch(Dispatchers.IO + CoroutineName("B")) {
            log("B's context: ${coroutineContext}")
            log("B's job: ${coroutineContext.job}")
            log("B's parent: ${coroutineContext.job.parent}")
            log("B's children: ${coroutineContext.job.children.toList()}")
        }
        log("A's children: ${coroutineContext.job.children.toList()}")

    }
