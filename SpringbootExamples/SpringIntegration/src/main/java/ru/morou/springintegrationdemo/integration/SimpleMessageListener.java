package ru.morou.springintegrationdemo.integration;

import org.slf4j.Logger;
import org.springframework.integration.annotation.MessageEndpoint;

import static org.slf4j.LoggerFactory.getLogger;

@MessageEndpoint
public class SimpleMessageListener {

    private static final Logger LOG = getLogger(SimpleMessageListener.class);

//    @ServiceActivator(inputChannel = SimpleMessageGateway.NULLABLE_CHANNEL)
//    public void handler(final SimpleMessage message, @Header("REQ_ID") final String reqId) {
//        LOG.info(reqId);
//        LOG.info("SimpleMessage: {}", message.getDate());
//    }

}
