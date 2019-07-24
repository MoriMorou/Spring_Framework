package ru.morou.springintegrationdemo.integration;

import org.slf4j.Logger;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.Router;
import org.springframework.util.StringUtils;
import ru.morou.springintegrationdemo.dto.WelcomeMessage;

import static org.slf4j.LoggerFactory.getLogger;

@MessageEndpoint
public class WelcomeRouter {

    private static final Logger LOG = getLogger(WelcomeRouter.class);

    @Router(inputChannel = WelcomeMessageGateway.ROUTER_CHANNEL)
    public String route(final WelcomeMessage message) {
        if (StringUtils.isEmpty(message.getMsg())) return WelcomeMessageGateway.NULLABLE_CHANNEL;
        return WelcomeMessageGateway.NOT_NULL_CHANNEL;
    }

}
