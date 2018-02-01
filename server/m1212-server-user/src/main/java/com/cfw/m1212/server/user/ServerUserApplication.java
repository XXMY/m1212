package com.cfw.m1212.server.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by Cfw on 2017/3/10.
 */
@SpringBootApplication(scanBasePackages = {
        "com.cfw.plugins",
        "com.cfw.m1212"})
//@ImportResource(locations = {"classpath:ApplicationContext-*.xml"})
public class ServerUserApplication {

    public static void main(String [] args) throws Exception {
        System.out.println("System startup ...");
        try{
            SpringApplication.run(ServerUserApplication.class);
        }catch (Exception e){
            throw new Exception(e);
        }

        System.out.println("System startup done.");
    }
}
