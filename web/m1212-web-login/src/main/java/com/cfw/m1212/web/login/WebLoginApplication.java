package com.cfw.m1212.web.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.ApplicationContext;

/**
 * Created by Cfw on 2017/3/10.
 */
@SpringBootApplication(scanBasePackages = {
        "com.cfw.plugins",
        "com.cfw.m1212"})
@EnableFeignClients
public class WebLoginApplication {
    private static Logger logger = LoggerFactory.getLogger(WebLoginApplication.class);

    public static void main(String [] args) throws Exception {
        logger.info("System startup ...");
        ApplicationContext applicationContext = null;
        try{
            applicationContext = SpringApplication.run(WebLoginApplication.class);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
        }
        logger.info("System startup done.");
    }
}
