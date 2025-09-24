package org.javagirls.coroutines

import kotlinx.coroutines.*

class ComponentWithScope(dispatcher: CoroutineDispatcher = Dispatchers.Default) {
    private val scope = CoroutineScope(dispatcher + SupervisorJob())

    fun start() {
        log("Starting")
        scope.launch {
            while(true) {
                delay(500)
                log("component working")
            }
        }
        scope.launch {
            log("Doing a one-off task ...")
            delay(500)
            log("Task done!")
        }
    }

    fun stop() {
        log("Stopping")
        scope.cancel()
    }
}

fun main() {
    val c = ComponentWithScope()
    c.start()
    Thread.sleep(2000)
    c.stop()
}