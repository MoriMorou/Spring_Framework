package ru.morou.springintegrationdemo.integration;

import org.slf4j.Logger;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;
import ru.morou.springintegrationdemo.dto.WelcomeMessage;

import static org.slf4j.LoggerFactory.getLogger;

@MessageEndpoint
public class WelcomeNullableListener {

    private static final Logger LOG = getLogger(WelcomeNullableListener.class);

    @ServiceActivator(inputChannel = WelcomeMessageGateway.NULLABLE_CHANNEL)
    public void handler(final WelcomeMessage message) {
        LOG.info("HELLO NONE!!");
    }

}
