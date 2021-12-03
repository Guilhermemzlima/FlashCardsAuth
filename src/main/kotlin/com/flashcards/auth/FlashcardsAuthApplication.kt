package com.flashcards.auth

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class FlashcardsAuthApplication

fun main(args: Array<String>) {
    runApplication<FlashcardsAuthApplication>(*args)
}
