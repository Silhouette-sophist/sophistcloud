package com.example.sophistcloud.config;


import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitmqConfig {


    public static final String EXCHANGE_TOPICS_INFO ="exchange_topics_info";
    public static final String QUEUE_FIRST = "queue_first";
    public static final String QUEUE_SECOND = "queue_second";
    public static final String ROUTING_KEY_FIRST ="info.first";
    public static final String ROUTING_KEY_SECOND ="info.second";

    /**
     * 声明交换机，直接接受消息，然后根据路由等将消息放入绑定在交换机上的队列中
     */
    @Bean(EXCHANGE_TOPICS_INFO)
    public Exchange exchangeTopicsInfo(){
        //durable(true) 持久化，mq重启之后交换机还在
        return ExchangeBuilder
                .topicExchange(EXCHANGE_TOPICS_INFO)
                .durable(true)
                .build();
    }

    /**
     * 声明第一个消息队列
     */
    @Bean(QUEUE_FIRST)
    public Queue queueInfoEmail(){
        return new Queue(QUEUE_FIRST);
    }

    /**
     * 声明第二个队列
     */
    @Bean(QUEUE_SECOND)
    public Queue queueInfoSms(){
        return new Queue(QUEUE_SECOND);
    }

    /**
     * 第一个队列绑定到交换机上
     */
    @Bean
    public Binding bindingQueueInfoEmail(@Qualifier(QUEUE_FIRST) Queue queue,
                                         @Qualifier(EXCHANGE_TOPICS_INFO) Exchange exchange){
        return BindingBuilder
                .bind(queue)
                .to(exchange)
                .with(ROUTING_KEY_FIRST)
                .noargs();
    }

    /**
     * 第二个队列绑定到交换机上
     */
    @Bean
    public Binding bindingRoutingKeySms(@Qualifier(QUEUE_SECOND) Queue queue,
                                        @Qualifier(EXCHANGE_TOPICS_INFO) Exchange exchange){
        return BindingBuilder
                .bind(queue)
                .to(exchange)
                .with(ROUTING_KEY_SECOND)
                .noargs();
    }

}