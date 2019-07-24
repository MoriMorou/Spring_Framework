package ru.morou.springintegrationdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.morou.springintegrationdemo.dto.ResultDTO;
import ru.morou.springintegrationdemo.dto.SuccessDTO;
import ru.morou.springintegrationdemo.integration.broadcast.BroadcastGateway;

@RestController
@RequestMapping("api/broadcast")
public class BroadcastController {

    @Autowired
    private BroadcastGateway broadcastGateway;

    @GetMapping(produces = "application/json")
    public ResultDTO broadcast() {
        for (int i = 0; i < 10; i++) {
            broadcastGateway.fire(MessageBuilder.withPayload("HELLO!!").build());
        }
        return new SuccessDTO();
    }


}
