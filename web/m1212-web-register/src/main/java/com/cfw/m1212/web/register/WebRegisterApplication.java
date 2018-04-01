package com.cfw.m1212.web.register;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * Created by Cfw on 2017/3/10.
 */
@SpringBootApplication(scanBasePackages = {
        "com.cfw.plugins",
        "com.cfw.m1212",
})
@EnableFeignClients
public class WebRegisterApplication {

    public static void main(String [] args) throws Exception {
        System.out.println("System startup ...");
        try{
            SpringApplication.run(WebRegisterApplication.class);
        }catch (Exception e){
            throw new Exception(e);
        }

        System.out.println("System startup done.");
    }
}