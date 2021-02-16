package com.ortiz.com.ortiz.business;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import static com.ortiz.com.ortiz.business.config.Constants.QUEUE_NAME;

@Component
@Slf4j
public class QueueReceiver {

    @RabbitListener(queues = QUEUE_NAME)
    public void processFailedMessages(Message message) {
        log.info("Received failed message: {}", message.toString());
    }
}
