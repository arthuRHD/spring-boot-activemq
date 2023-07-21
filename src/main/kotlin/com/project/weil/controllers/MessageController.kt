package com.project.weil.controllers

import jakarta.jms.TextMessage
import org.springframework.beans.factory.annotation.Value
import org.springframework.jms.core.JmsTemplate
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("message")
class MessageController(
        private val jmsTemplate: JmsTemplate,
        @Value("\${spring.activemq.queue-name}") private val queueName: String
) {

    @GetMapping("/sendHello")
    fun sendHello(): String {
        jmsTemplate.send(queueName) { messageCreator ->
            val message: TextMessage = messageCreator.createTextMessage()
            message.text = "Hi everyone !"
            message
        }
        return "Sent to the queue."
    }

}