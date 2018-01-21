package com.cfw.m1212.web.test.controller;

import com.cfw.m1212.web.test.bo.Cat;
import com.cfw.m1212.web.test.bo.HttpResponseBo;
import com.cfw.plugins.http.annotation.RequestPath;
import com.cfw.plugins.netty.http.HttpMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

@Controller
@RequestPath("/")
public class IndexController {
    private Logger logger = LoggerFactory.getLogger(IndexController.class);

    @RequestPath("index")
    public String index(){
        System.out.println("Get in.");
        return "This is index";
    }

    @RequestPath(value = "index2",method = HttpMethod.PUT)
    public HttpResponseBo index2(String name, int age){
        this.logger.info("Request Parameter: name={}, age={}", name,age);
        HttpResponseBo responseBo = new HttpResponseBo();
        responseBo.setCode(0);
        responseBo.setDescription("success");
        responseBo.setData("Hello "+name+", my name is CaiFangwei");

        return responseBo;
    }

    @RequestPath(value = "index3",method = HttpMethod.POST)
    public HttpResponseBo index3(Cat cat){
        this.logger.info("Request Parameter: cat={}", cat);
        HttpResponseBo responseBo = new HttpResponseBo();
        responseBo.setCode(0);
        responseBo.setDescription("success");
        responseBo.setData("Hello "+cat.getName()+", my name is CaiFangwei");

        return responseBo;
    }
}
