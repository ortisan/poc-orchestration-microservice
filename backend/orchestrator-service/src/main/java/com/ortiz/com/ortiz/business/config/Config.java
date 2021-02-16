package com.ortiz.com.ortiz.business.config;

import com.ortiz.com.ortiz.business.QueueReceiver;
import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static com.ortiz.com.ortiz.business.config.Constants.QUEUE_NAME;
import static com.ortiz.com.ortiz.business.config.Constants.TOPIC_EXCHANGE_NAME;

@Configuration
public class Config {

    @Bean
    public WebClient webClient() {
        HttpClient httpClient = HttpClient.create()
                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 5000)
                .responseTimeout(Duration.ofMillis(5000))
                .doOnConnected(conn ->
                        conn.addHandlerLast(new ReadTimeoutHandler(5000, TimeUnit.MILLISECONDS))
                                .addHandlerLast(new WriteTimeoutHandler(5000, TimeUnit.MILLISECONDS)));

        WebClient client = WebClient.builder()
                .clientConnector(new ReactorClientHttpConnector(httpClient))
                .build();

        return client;
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public Queue deadLetterQueue() {
        return QueueBuilder.durable(QUEUE_NAME)
                .withArgument("x-dead-letter-exchange", TOPIC_EXCHANGE_NAME)
                .build();
    }

    @Bean
    public FanoutExchange deadLetterExchange() {
        return new FanoutExchange(TOPIC_EXCHANGE_NAME);
    }

    @Bean
    public Binding deadLetterBinding() {
        return BindingBuilder.bind(deadLetterQueue()).to(deadLetterExchange());
    }

    @Bean
    public SimpleMessageListenerContainer container(ConnectionFactory connectionFactory,
                                                    MessageListenerAdapter listenerAdapter) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setQueueNames(QUEUE_NAME);
        container.setMessageListener(listenerAdapter);
        return container;
    }

    @Bean
    MessageListenerAdapter listenerAdapter(QueueReceiver receiver) {
        return new MessageListenerAdapter(receiver, "receiveMessage");
    }

    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

}
