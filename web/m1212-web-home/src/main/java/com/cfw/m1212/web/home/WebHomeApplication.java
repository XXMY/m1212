package com.cfw.m1212.web.home;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * Created by Cfw on 2017/3/10.
 */
@SpringBootApplication(scanBasePackages = {
        "com.cfw.plugins",
        "com.cfw.m1212"})
@ImportResource(locations = {"classpath:ApplicationContext-*.xml"})
public class WebHomeApplication {

    public static void main(String [] args) throws Exception {
        System.out.println("System startup ...");
        try{
            SpringApplication.run(WebHomeApplication.class);
        }catch (Exception e){
            throw new Exception(e);
        }

        System.out.println("System startup done.");
    }
}
