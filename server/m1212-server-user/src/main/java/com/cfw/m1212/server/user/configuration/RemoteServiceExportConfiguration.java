package com.cfw.m1212.server.user.configuration;

import com.cfw.m1212.api.UserService;
import com.cfw.plugins.mq.rabbitmq.rpc.AmqpInvokerExtendedServiceExporter;
import com.cfw.plugins.mq.rabbitmq.rpc.SimpleMessageExtendedListenerContainer;
import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Duskrain on 2017/9/10.
 */
@Configuration
public class RemoteServiceExportConfiguration {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private CachingConnectionFactory rabbitConnectionFactory;

    @Bean("userServiceExporter")
    public AmqpInvokerExtendedServiceExporter exportUerService(UserService userService){
        AmqpInvokerExtendedServiceExporter serviceExporter = new AmqpInvokerExtendedServiceExporter();
        serviceExporter.setServiceInterface(UserService.class);
        serviceExporter.setService(userService);
        serviceExporter.setAmqpTemplate(rabbitTemplate);

        return serviceExporter;
    }

    @Bean
    public SimpleMessageExtendedListenerContainer userServiceListenerContainer(AmqpInvokerExtendedServiceExporter serviceExporter){
        SimpleMessageExtendedListenerContainer listenerContainer = new SimpleMessageExtendedListenerContainer();
        listenerContainer.setAcknowledgeMode(AcknowledgeMode.NONE);
        listenerContainer.setMaxConcurrentConsumers(5);
        listenerContainer.setPrefetchCount(1);
        listenerContainer.setConnectionFactory(rabbitConnectionFactory);
        listenerContainer.setQueueNames("m1212-server-user-rpc-queue");
        listenerContainer.setMessageListener(serviceExporter);

        return listenerContainer;
    }
}
