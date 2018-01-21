package com.cfw.m1212.web.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {
        "com.cfw.plugins",
        "com.cfw.m1212"})
public class Application {

    public static void main(String [] args){
        SpringApplication.run(Application.class);
    }
}
