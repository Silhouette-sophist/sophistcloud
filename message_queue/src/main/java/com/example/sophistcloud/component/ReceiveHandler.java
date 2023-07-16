package com.example.sophistcloud.component;


import com.example.sophistcloud.config.RabbitmqConfig;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

import org.springframework.stereotype.Component;

/**
 * @ClassName ReceiveHandler
 * @Description TODO
 * @Author 胡泽
 * @Date 2019/12/17 13:02
 * @Version 1.0
 */
@Slf4j
@Component
public class ReceiveHandler {

    @RabbitListener(queues = {RabbitmqConfig.QUEUE_FIRST})
    public void receiveFirst(Object msg, Message message, Channel channel){
        log.info("first queue msg"+msg);
    }

    @RabbitListener(queues = {RabbitmqConfig.QUEUE_SECOND})
    public void receiveSecond(Object msg, Message message, Channel channel){
        log.info("second queue msg"+msg);
    }
}