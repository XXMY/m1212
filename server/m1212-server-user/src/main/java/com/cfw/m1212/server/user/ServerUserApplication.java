package com.cfw.m1212.server.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by Cfw on 2017/3/10.
 */
@SpringBootApplication(scanBasePackages = {
        "com.cfw.plugins",
        "com.cfw.m1212"})
public class ServerUserApplication {

    private static Logger logger = LoggerFactory.getLogger(ServerUserApplication.class);

    public static void main(String [] args) throws Exception {
        logger.info("System startup ...");
        try{
            SpringApplication.run(ServerUserApplication.class);
        }catch (Exception e){
            throw new Exception(e);
        }
        logger.info("System startup done.");
    }
}
