package com.cfw.m1212.web.register.controller;

import com.cfw.m1212.model.db.User;
import com.cfw.m1212.web.commons.controller.BaseController;
import com.cfw.m1212.web.commons.enums.ResponseTypeEnum;
import com.cfw.m1212.web.commons.vo.MoviesResponse;
import com.cfw.m1212.web.commons.vo.RsaVO;
import com.cfw.m1212.web.register.service.UserRegisterService;
import com.cfw.plugins.security.rsa.RSA;
import com.cfw.plugins.security.rsa.RSAKeyPairs;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.PrivateKey;
import java.util.UUID;

/**
 * @author Fangwei_Cai
 * @time since 2016年3月26日 下午8:49:13
 */
@Controller
@RequestMapping(value="/Register",method=RequestMethod.POST)
public class RegisterController extends BaseController {
    private Logger logger = LoggerFactory.getLogger(RegisterController.class);

	@Autowired
	private UserRegisterService userRegisterServiceImpl;
	
	/**
	 * @author Fangwei_Cai
	 * @time since 2016年3月26日 下午8:05:55
	 */
	@RequestMapping(value="/userCheck")
	@ResponseBody
	public MoviesResponse userCheck(String username){
		String requestId = UUID.randomUUID().toString();
		this.logger.info("[/Register/userCheck] Request Parameters: username={}, requestId={}",username,requestId);
		MoviesResponse response = new MoviesResponse();

		try{
            if(StringUtils.isEmpty(username)){
                response = buildResponse(ResponseTypeEnum.PARAM_WRONG,requestId);
            } else if(!userRegisterServiceImpl.userExists(username,requestId)){
                response = buildResponse(ResponseTypeEnum.SUCCESS,requestId);
            }else{
                response = buildResponse(ResponseTypeEnum.USER_EXISTS,requestId);
            }
        }catch (Exception e){
            this.logger.error("[/Register/userCheck] Exception: "+e.getMessage() +", requestId="+requestId,e);
            response = buildResponse(ResponseTypeEnum.SYSTEM_ERROR,requestId);
        }

        this.logger.info("[/Register/userCheck] Response: {}",response);
        return response;
	}
	
	/**
	 * @author Fangwei_Cai
	 * @time since 2016年3月27日 上午10:15:19
	 */
	@RequestMapping("/registerUser")
	@ResponseBody
	public MoviesResponse userRegister(RsaVO rsaVO){
        String requestId = UUID.randomUUID().toString();
        this.logger.info("[/Register/userCheck] Request Parameters: rsaVO={}, requestId={}",rsaVO,requestId);
		MoviesResponse response = new MoviesResponse();

		try{
			String decoded = RSA.decodeBase64String((PrivateKey) RSAKeyPairs.publicPrivateKeys[1].get(rsaVO.getV()),rsaVO.getData());
			Gson gson = new Gson();
            User user = gson.fromJson(decoded,User.class);
            this.logger.info("[/Register/userCheck] Request Parameters: user={}, requestId={}",user,requestId);

            if(user.getUsername().isEmpty() || user.getPassword().isEmpty()){
                response = buildResponse(ResponseTypeEnum.PARAM_WRONG,requestId);
            } else if(userRegisterServiceImpl.register(user,requestId)){
                response = buildResponse(ResponseTypeEnum.SUCCESS,requestId);
            }else{
                response = buildResponse(ResponseTypeEnum.USER_EXISTS,requestId);
            }
		}catch(Exception e){
            this.logger.error("[/Register/registerUser] Exception: "+e.getMessage() +", requestId="+requestId,e);
			response = buildResponse(ResponseTypeEnum.SYSTEM_ERROR,requestId);
		}

        this.logger.info("[/Register/registerUser] Response: {}",response);
		return response;
	}
	
}
