package ru.morou.springintegrationdemo.integration;

import org.slf4j.Logger;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.Transformer;
import ru.morou.springintegrationdemo.dto.SimpleMessage;
import ru.morou.springintegrationdemo.dto.TextMessage;

import static org.slf4j.LoggerFactory.getLogger;

@MessageEndpoint
public class SimpleToTextMessageTransformer {

    private static final Logger LOG = getLogger(SimpleToTextMessageTransformer.class);

    @Transformer(inputChannel = SimpleMessageGateway.CHANNEL, outputChannel = TextMessageGateway.CHANNEL)
    public TextMessage transform(final SimpleMessage message) {
        return new TextMessage(message.getDate().toString());
    }

}
