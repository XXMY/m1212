package com.cfw.m1212.web.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Index")
public class IndexController {

    @RequestMapping("/index")
    public void index(String data){
        System.out.println(this.decodeRequestData(data));
    }

    private String decodeRequestData(String requestData){
        if(StringUtils.isEmpty(requestData))
            return "";

        Integer fix = (int)requestData.charAt(requestData.length()-1);
        String encrypted = requestData.substring(0,requestData.length()-1);
        String plainText = "";
        for(int i=0;i<encrypted.length();i++){
            String hexString = Integer.toHexString(encrypted.charAt(i));
            int unicode = Integer.parseInt(hexString,16) - fix - i;
            plainText += (char) unicode;
        }
        return plainText;
    }

}
