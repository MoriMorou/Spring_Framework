package ru.morou.springintegrationdemo.integration;

import org.slf4j.Logger;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;
import ru.morou.springintegrationdemo.dto.TextMessage;

import static org.slf4j.LoggerFactory.getLogger;

@MessageEndpoint
public class TextMessageListener {

    private static final Logger LOG = getLogger(TextMessageListener.class);

    @ServiceActivator(inputChannel = TextMessageGateway.CHANNEL)
    public void handler(final TextMessage message) {
        LOG.info("TextMessage: {}", message.getText());
    }

}
