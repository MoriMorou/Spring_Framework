package ru.morou.springintegrationdemo.integration;

import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.messaging.Message;
import ru.morou.springintegrationdemo.dto.WelcomeMessage;

@MessagingGateway(
        name = WelcomeMessageGateway.GATEWAY,
        defaultRequestChannel = WelcomeMessageGateway.ROUTER_CHANNEL)
public interface WelcomeMessageGateway {

    String ROUTER_CHANNEL = "welcomeMessageChannel";

    String NULLABLE_CHANNEL = "welcomeNullableMessageChannel";

    String NOT_NULL_CHANNEL = "welcomeNotNullMessageChannel";

    String GATEWAY = "welcomeMessageGateway";

    @Gateway
    void fire(Message<WelcomeMessage> message);

}
