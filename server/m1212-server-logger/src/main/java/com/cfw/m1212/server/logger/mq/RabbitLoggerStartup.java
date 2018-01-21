package com.cfw.m1212.server.logger.mq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;

import java.util.Map;

/**
 * Created by Duskrain on 2017/8/13.
 */
public class RabbitLoggerStartup {

    private static boolean started;

    public static void startup(RabbitTemplate rabbitTemplate, Map<String,Integer> queueThreadsNumber) throws Exception {
        if(!started)
            RabbitLoggerThread.staticStartup(rabbitTemplate,queueThreadsNumber);

        started = true;
    }
}
