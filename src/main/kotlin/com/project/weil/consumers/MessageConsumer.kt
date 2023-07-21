package com.project.weil.consumers

import org.springframework.jms.annotation.JmsListener
import org.springframework.stereotype.Component

@Component
class MessageConsumer {

    @JmsListener(destination = "\${spring.activemq.queue-name}")
    fun processMessage(content: String?) {
        println(content)
    }
}