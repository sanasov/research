package ru.igrey.dev.kafka

import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component

@Component
class CardProducer(private val kafkaTemplate: KafkaTemplate<String, String>) {

    fun sendMessage(msg: String) {
        kafkaTemplate.send("card",  "${msg}_key", "${msg}_value").join()
    }
}