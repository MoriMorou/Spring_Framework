package ru.morou.springintegrationdemo.integration;

import org.slf4j.Logger;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;
import ru.morou.springintegrationdemo.dto.WelcomeMessage;

import static org.slf4j.LoggerFactory.getLogger;

@MessageEndpoint
public class WelcomeNotNullListener {

    private static final Logger LOG = getLogger(WelcomeNotNullListener.class);

    @ServiceActivator(inputChannel = WelcomeMessageGateway.NOT_NULL_CHANNEL)
    public void handler(final WelcomeMessage message) {
        LOG.info("HELLO {}!!", message.getMsg());
    }

}
