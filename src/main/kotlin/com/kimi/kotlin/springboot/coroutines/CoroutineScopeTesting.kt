package com.kimi.kotlin.springboot.coroutines

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

private fun log(msg: String) = println("[${Thread.currentThread().name}] $msg")

suspend fun main() {
    networkRequest1()
}

private suspend fun networkRequest1() {

    val time = measureTimeMillis {

        val job = GlobalScope.launch {
            Dispatchers.IO

            runBlocking {
                log("Starting runBlocking...")
                delay(1000)
                log("runBlocking...")
                delay(1000)
            }

            coroutineScope {
                log("Starting coroutineScope...")
                delay(1000)
                log("coroutineScope...")
                delay(1000)
            }

        }
        delay(400)
        log("Cancelling job...")
        job.cancel()

        job.join()
        log("Done!")
    }
    log("Time = $time")
}
