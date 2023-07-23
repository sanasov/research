package ru.igrey.dev.web

import org.apache.commons.lang3.RandomStringUtils
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.igrey.dev.kafka.CardProducer

@RestController
@RequestMapping("cards")
class CardController(private val cardProducer: CardProducer) {

    @PostMapping("{card}")
    fun addCard(@PathVariable card: String): String {
        cardProducer.sendMessage(card)
        return card
    }

    @PostMapping
    fun addCards(): String {
        val generatedString: String = RandomStringUtils.random(10, true, false)
        for (i in 0..1000) {
            cardProducer.sendMessage("${generatedString}_$i")
        }
        return generatedString
    }
}
