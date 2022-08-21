package com.kimi.kotlin.springboot.suspendtesting

fun main(args: Array<String>) {
    println(parentFun())
}

fun childFun1(): Int {
    return 10
}

fun childFun2(): Int {
    return 20
}

fun childFun3(num1: Int, num2: Int): Int {
    return num1 + num2
}

fun parentFun(): Int {
    val num1 = childFun1()
    val num2 = childFun2()
    val sum = childFun3(num1, num2)
    return sum
}

class SuspendTesting {

}