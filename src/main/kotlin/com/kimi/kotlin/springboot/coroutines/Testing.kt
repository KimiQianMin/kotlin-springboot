package com.kimi.kotlin.springboot.coroutines

import kotlinx.coroutines.*

//suspend fun main() = coroutineScope {
//    launch {
//        delay(1000)
//        println("Kotlin Coroutines World!")
//    }
//    println("Hello")
//}

private fun log(msg: String) = println("[${Thread.currentThread().name}] $msg")

fun main() {
    networkRequest()
}

fun networkRequest() {

    GlobalScope.launch {
        log("Making first network request...")

        for (i in 1..3) {
            delay(1000)
            println("First: $i")
        }
        log("First network request made!")
    }

    GlobalScope.launch {
        delay(500)
        log("Making second network request...")

        for (i in 1..3) {
            delay(1000)
            println("Second: $i")
        }
        log("Second network request made!")
    }

    Thread.sleep(2000)

    log("Done!")

}
