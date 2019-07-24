package ru.morou.springintegrationdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.morou.springintegrationdemo.dto.ResultDTO;
import ru.morou.springintegrationdemo.dto.SimpleMessage;
import ru.morou.springintegrationdemo.dto.SuccessDTO;
import ru.morou.springintegrationdemo.dto.WelcomeMessage;
import ru.morou.springintegrationdemo.integration.SimpleMessageGateway;
import ru.morou.springintegrationdemo.integration.WelcomeMessageGateway;

import java.util.UUID;

@RestController
@RequestMapping("api/message")
public class MessageController {

    @Autowired
    private SimpleMessageGateway simpleMessageGateway;

    @Autowired
    private WelcomeMessageGateway welcomeMessageGateway;


    @RequestMapping(value = "/ping", produces = "application/json")
    public ResultDTO ping() {
        return new SuccessDTO();
    }

    @RequestMapping(value = "/simple", method = RequestMethod.GET, produces = "application/json")
    public ResultDTO send() {
        simpleMessageGateway.fire(MessageBuilder
                .withPayload(new SimpleMessage())
                .setHeader("REQ_ID", UUID.randomUUID().toString())
                .build());
        return new SuccessDTO();
    }

    @RequestMapping(value = "/welcome", method = RequestMethod.GET, produces = "application/json")
    public ResultDTO welcome(@RequestParam(name = "msg") String msg) {
        welcomeMessageGateway.fire(MessageBuilder
                .withPayload(new WelcomeMessage(msg))
                .build());
        return new SuccessDTO();
    }

}
