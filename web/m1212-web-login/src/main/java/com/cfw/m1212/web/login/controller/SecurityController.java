package com.cfw.m1212.web.login.controller;

import com.cfw.m1212.web.commons.controller.BaseController;
import com.cfw.m1212.web.commons.enums.ResponseTypeEnum;
import com.cfw.m1212.web.commons.vo.MoviesResponse;
import com.cfw.m1212.web.commons.vo.RsaVO;
import com.cfw.m1212.web.login.service.UserLoginService;
import com.cfw.plugins.security.properties.SecurityProperties;
import com.cfw.plugins.security.rsa.RSAKeyPairs;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.interfaces.RSAPublicKey;
import java.util.Random;
import java.util.UUID;

/**
 * Created by Cfw on 2017/4/4.
 */
@Controller
@RequestMapping("/Login/Security")
public class SecurityController extends BaseController {
    private Logger logger = LoggerFactory.getLogger(SecurityController.class);

    /**
     * 获得秘钥
     * @author CaiFangwei
     * @time since 2017-1-17 14:10:49
     * @return
     */
    @RequestMapping("/key")
    @ResponseBody
    public MoviesResponse key(){
        String requestId = UUID.randomUUID().toString();
        this.logger.info("[/Login/Security/key] RequestId={}",requestId);
        MoviesResponse response = new MoviesResponse();

        try{
            Random r = new Random();
            int number = r.nextInt(SecurityProperties.getRsaKeyPairNumber());
            RSAPublicKey publicKey = (RSAPublicKey) RSAKeyPairs.publicPrivateKeys[0].get(number);

            RsaVO rsaVO = new RsaVO();
            rsaVO.setV(number);
            rsaVO.setKey(Base64Utils.encodeToString(publicKey.getEncoded()));
            response.setData(rsaVO);
        }catch(Exception e){
            this.logger.error("[/User/key] " + e.getMessage() + "requestId="+requestId,e);
            response = buildResponse(ResponseTypeEnum.SYSTEM_ERROR,requestId);
        }

        return response;

    }
}
