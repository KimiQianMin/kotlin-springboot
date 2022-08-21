package com.kimi.kotlin.springboot.coroutines

import kotlinx.coroutines.*

private fun log(msg: String) = println("[${Thread.currentThread().name}] $msg")

fun main() {
    runBlocking {
        launch {
            checkgForInternet()
            makeAPIRequest()
        }
        launch {
            checkgForInternet()
            makeAPIRequest()
        }
        log("This will be printed first")
    }
    log("Finished!")
}

private suspend fun makeAPIRequest() {
    delay(100)
    log("API request failed because of missing internet.")
}

private suspend fun checkgForInternet() {
    delay(3000)
    log("There is internet")
    delay(3000)
    log("Just kidding, there is no internet")
}