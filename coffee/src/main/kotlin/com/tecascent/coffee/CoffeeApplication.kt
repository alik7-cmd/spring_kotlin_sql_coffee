package com.tecascent.coffee

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.stereotype.Component

@SpringBootApplication
@Component
class CoffeeApplication

fun main(args: Array<String>) {
	runApplication<CoffeeApplication>(*args)
}
