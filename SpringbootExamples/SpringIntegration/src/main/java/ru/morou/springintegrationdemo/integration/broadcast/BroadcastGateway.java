package ru.morou.springintegrationdemo.integration.broadcast;

import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.messaging.Message;

@MessagingGateway(
        name = BroadcastGateway.GATEWAY,
        defaultRequestChannel = BroadcastGateway.CHANNEL)
public interface BroadcastGateway {

    String CHANNEL = "broadcastChannel";

    String GATEWAY = "broadcastGateway";

    @Gateway
    void fire(Message<String> message);

}
