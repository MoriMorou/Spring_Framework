package ru.morou.springintegrationdemo.integration;

import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.messaging.Message;
import ru.morou.springintegrationdemo.dto.SimpleMessage;

@MessagingGateway(
        name = SimpleMessageGateway.GATEWAY,
        defaultRequestChannel = SimpleMessageGateway.CHANNEL)
public interface SimpleMessageGateway {

    String CHANNEL = "simpleMessageChannel";

    String GATEWAY = "simpleMessageGateway";

    @Gateway
    void fire(Message<SimpleMessage> message);

}
