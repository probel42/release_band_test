package ru.ibelan.arkanoid

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ArkanoidApplication

fun main(args: Array<String>) {
	runApplication<ArkanoidApplication>(*args)
}
