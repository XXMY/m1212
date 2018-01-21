package com.cfw.m1212.web.login.configuration;

import com.cfw.m1212.api.UserService;
import org.springframework.amqp.remoting.client.AmqpProxyFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Cfw on 2017/9/9.
 */
@Configuration
public class RpcClientConfiguration {

    @Autowired
    private AmqpProxyFactoryBean factoryBean;

    @Bean("userService")
    public UserService injectUserService() throws Exception {

        return (UserService) factoryBean.getObject();
    }
}
