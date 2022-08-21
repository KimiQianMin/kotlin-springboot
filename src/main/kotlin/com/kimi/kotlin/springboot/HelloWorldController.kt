package com.kimi.kotlin.springboot

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/hello")
class HelloWorldController {

    @GetMapping("/springboot")
    fun helloWorld(): String {
        return "springboot"
    }

    @GetMapping("/springboot1")
    fun helloWorld1(): String = "springboot1"
}