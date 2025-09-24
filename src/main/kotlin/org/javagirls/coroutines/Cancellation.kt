package org.javagirls.coroutines

import kotlinx.coroutines.*

fun main() = runBlocking(CoroutineName("A")) {
    lateinit var jobC: Job
    log(coroutineContext)
    val jobB = launch (CoroutineName("B")){
        log(coroutineContext)
        jobC = launch (CoroutineName("C")){
            log(coroutineContext)
            log("I'm started")
            delay(500)
            log("I'm done")
        }
    }
    delay(200)
    log(coroutineContext)

    jobB.cancel()
    println("jobB ativo: ${jobB.isActive}")
    println("jobC ativo: ${jobC.isActive}")
}