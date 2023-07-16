package com.example.sophistcloud.controller;

import cn.hutool.core.lang.UUID;
import com.example.sophistcloud.config.RabbitmqConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/rabbit")
public class MQController {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @GetMapping("/send")
    public Object sendMsg(@RequestParam("routeIndex") String routeIndex){
        String routeKey = null;
        if ("first".equals(routeIndex)) {
            routeKey = RabbitmqConfig.ROUTING_KEY_FIRST;
        } else if("second".equals(routeIndex)){
            routeKey = RabbitmqConfig.ROUTING_KEY_SECOND;
        } else{
            return null;
        }
        String uuid = UUID.randomUUID().toString();
        rabbitTemplate.send(routeKey, new Message(uuid.getBytes()));
        log.info("send message " + uuid);
        return uuid;
    }
}
