package com.cfw.m1212.web.register.controller;

import com.cfw.m1212.model.User;
import com.cfw.m1212.web.commons.controller.BaseController;
import com.cfw.m1212.web.commons.enums.ResponseTypeEnum;
import com.cfw.m1212.web.commons.vo.MoviesResponse;
import com.cfw.m1212.web.commons.vo.RsaVO;
import com.cfw.m1212.web.register.service.UserRegisterService;
import com.cfw.plugins.security.rsa.RSA;
import com.cfw.plugins.security.rsa.RSAKeyPairs;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.PrivateKey;

/**
 * @author Fangwei_Cai
 * @time since 2016年3月26日 下午8:49:13
 */
@Controller
@RequestMapping(value="/Register",method=RequestMethod.POST)
public class RegisterController extends BaseController {

	@Autowired
	private UserRegisterService userRegisterServiceImpl;
	
	/**
	 * @author Fangwei_Cai
	 * @time since 2016年3月26日 下午8:05:55
	 */
	@RequestMapping(value="/userCheck")
	@ResponseBody
	public MoviesResponse userCheck(String username){
		MoviesResponse response = new MoviesResponse();

		if(StringUtils.isEmpty(username)){
			response = buildResponse(ResponseTypeEnum.PARAM_WRONG);
			return response;
		}
		
		if(!userRegisterServiceImpl.userExists(username)){
			response = buildResponse(ResponseTypeEnum.SUCCESS);
			return response;
		}else{
			response = buildResponse(ResponseTypeEnum.USER_EXISTS);
			return response;
		}

	}
	
	/**
	 * @author Fangwei_Cai
	 * @time since 2016年3月27日 上午10:15:19
	 */
	@RequestMapping("/registerUser")
	@ResponseBody
	public MoviesResponse userRegister(RsaVO rsaVO){
		MoviesResponse response = new MoviesResponse();
		User user = null;

		try{
			String decoded = RSA.decodeBase64String((PrivateKey) RSAKeyPairs.publicPrivateKeys[1].get(rsaVO.getV()),rsaVO.getData());
			Gson gson = new Gson();
			user = (User)gson.fromJson(decoded,User.class);
		}catch(Exception e){
			response = buildResponse(ResponseTypeEnum.SYSTEM_ERROR);
			return response;
		}

		if(user.getUsername().isEmpty() || user.getPassword().isEmpty()){
			response = buildResponse(ResponseTypeEnum.PARAM_WRONG);
		}

		
		if(userRegisterServiceImpl.register(user)){
			response = buildResponse(ResponseTypeEnum.SUCCESS);
			return response;
		}else{
			response = buildResponse(ResponseTypeEnum.USER_EXISTS);

			return response;
		}

	}
	
}
