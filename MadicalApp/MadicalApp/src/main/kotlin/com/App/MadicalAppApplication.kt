package com.App

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MadicalAppApplication

fun main(args: Array<String>) {
	runApplication<MadicalAppApplication>(*args)
}
