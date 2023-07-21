package com.project.weil.consumers

import lombok.AllArgsConstructor
import lombok.extern.slf4j.Slf4j
import org.springframework.jms.annotation.JmsListener
import org.springframework.stereotype.Component

@Component
@AllArgsConstructor
@Slf4j
class MessageConsumer {

    @JmsListener(destination = "\${spring.activemq.queueName}")
    fun processMessage(content: String?) {
        println(content)
    }
}