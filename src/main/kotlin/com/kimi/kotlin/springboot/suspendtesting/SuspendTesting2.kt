package com.kimi.kotlin.springboot.suspendtesting

suspend fun main(args: Array<String>) {
    println(parentFun1())
}

suspend fun childFun11(): Int {
    delay(3)
    println("childFun11")
    return 10
}

suspend fun childFun22(): Int {
    delay(4)
    println("childFun22")
    return 20
}

suspend fun childFun33(num1: Int, num2: Int): Int {
    delay(1)
    println("childFun33")
    return num1 + num2
}

fun delay(duration: Int) {
    Thread.sleep(duration * 1000L)
}

suspend fun parentFun1(): Int {
    val num1 = childFun11()
    val num2 = childFun22()
    val sum = childFun33(num1, num2)
    return sum
}

class SuspendTesting2 {

}