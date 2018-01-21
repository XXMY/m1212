package com.cfw.m1212.server.comment.configuration;

import com.cfw.m1212.api.UserService;
import com.cfw.plugins.mq.rabbitmq.rpc.AmqpProxyExtendedFactoryBean;
import com.cfw.plugins.mq.rabbitmq.rpc.MessageExtendedPostProcesser;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Duskrain on 2017/9/10.
 */
@Configuration
public class RemoteServiceInjectConfiguration {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private MessageExtendedPostProcesser messageExtendedPostProcesser;

    @Bean
    public AmqpProxyExtendedFactoryBean createRemoteUserServiceFactory() throws Exception {
        AmqpProxyExtendedFactoryBean factoryBean = new AmqpProxyExtendedFactoryBean();
        factoryBean.setServiceInterface(UserService.class);
        factoryBean.setRoutingKey("m1212-server-user-rpc-queue");
        factoryBean.setAmqpTemplate(rabbitTemplate);
        factoryBean.setMessagePostProcesser(messageExtendedPostProcesser);

        return factoryBean;
    }

}
