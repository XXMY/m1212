package com.cfw.m1212.web.comment.configuration;

import com.cfw.m1212.api.CommentService;
import com.cfw.m1212.api.DescriptionService;
import com.cfw.m1212.api.MovieService;
import com.cfw.m1212.api.TypeService;
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
    public AmqpProxyExtendedFactoryBean injectRemoteCommentService() throws Exception {
        AmqpProxyExtendedFactoryBean factoryBean = new AmqpProxyExtendedFactoryBean();
        factoryBean.setServiceInterface(CommentService.class);
        factoryBean.setRoutingKey("m1212-server-comment-rpc-queue");
        factoryBean.setAmqpTemplate(rabbitTemplate);
        factoryBean.setMessagePostProcesser(messageExtendedPostProcesser);

        return factoryBean;
    }

}
