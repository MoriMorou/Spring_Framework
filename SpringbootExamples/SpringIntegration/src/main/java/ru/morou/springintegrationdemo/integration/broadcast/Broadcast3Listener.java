package ru.morou.springintegrationdemo.integration.broadcast;

import org.slf4j.Logger;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;

import static org.slf4j.LoggerFactory.getLogger;

@MessageEndpoint
public class Broadcast3Listener {

    private static final Logger LOG = getLogger(Broadcast3Listener.class);

    @ServiceActivator(inputChannel = BroadcastGateway.CHANNEL)
    public void handler(final String message) {
        LOG.info("Broadcast 3: {}", message);
    }

}
