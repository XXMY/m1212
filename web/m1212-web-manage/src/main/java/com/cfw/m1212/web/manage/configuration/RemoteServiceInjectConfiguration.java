package com.cfw.m1212.web.manage.configuration;

import com.cfw.m1212.api.DescriptionService;
import com.cfw.m1212.api.MovieService;
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
    public AmqpProxyExtendedFactoryBean injectRemoteMovieService() throws Exception {
        AmqpProxyExtendedFactoryBean factoryBean = new AmqpProxyExtendedFactoryBean();
        factoryBean.setServiceInterface(MovieService.class);
        factoryBean.setRoutingKey("m1212-server-movie-rpc-queue");
        factoryBean.setAmqpTemplate(rabbitTemplate);
        factoryBean.setMessagePostProcesser(messageExtendedPostProcesser);

        return factoryBean;
    }

    @Bean
    public AmqpProxyExtendedFactoryBean injectRemoteDescriptionService() throws Exception {
        AmqpProxyExtendedFactoryBean factoryBean = new AmqpProxyExtendedFactoryBean();
        factoryBean.setServiceInterface(DescriptionService.class);
        factoryBean.setRoutingKey("m1212-server-description-rpc-queue");
        factoryBean.setAmqpTemplate(rabbitTemplate);
        factoryBean.setMessagePostProcesser(messageExtendedPostProcesser);

        return factoryBean;
    }

}
