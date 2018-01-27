package com.cfw.m1212.server.logger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * Created by Duskrain on 2017/8/11.
 */
@SpringBootApplication(scanBasePackages = {
        "com.cfw.plugins",
        "com.cfw.m1212"
})
@ImportResource(locations = {"classpath:ApplicationContext-*.xml"})
public class ServerLoggerApplication {

    public static void main(String [] args) throws Exception {
        System.out.println("System startup ...");
        try{
            SpringApplication.run(ServerLoggerApplication.class);
        }catch (Exception e){
            throw new Exception(e);
        }

        System.out.println("System startup done.");
    }
}
