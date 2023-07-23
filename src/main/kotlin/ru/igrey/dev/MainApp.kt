package ru.igrey.dev

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.kafka.annotation.EnableKafka


@SpringBootApplication
@EnableKafka
open class MainApp

fun main(args: Array<String>) {
    runApplication<MainApp>(*args)
}
