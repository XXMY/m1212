package com.cfw.m1212.web.login.controller;

import com.cfw.m1212.model.User;
import com.cfw.m1212.web.commons.controller.BaseController;
import com.cfw.m1212.web.commons.enums.ResponseTypeEnum;
import com.cfw.m1212.web.commons.vo.MoviesResponse;
import com.cfw.m1212.web.commons.vo.RsaVO;
import com.cfw.m1212.web.login.service.UserLoginService;
import com.cfw.plugins.security.rsa.RSA;
import com.cfw.plugins.security.rsa.RSAKeyPairs;
import com.google.gson.Gson;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.security.PrivateKey;
import java.util.UUID;

/**
 * @author Fangwei_Cai
 * @time since 2016年5月1日 下午10:00:20
 */
@Controller
@RequestMapping("/Login")
public class LoginController extends BaseController {
	
	@Resource(name = "userLoginService")
	private UserLoginService userLoginService;

	private Logger logger = LoggerFactory.getLogger(LoginController.class);

	/**
	 * Check user whether logined.
	 * @author Fangwei_Cai
	 * @time since 2016年5月1日 下午10:11:32
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/logined",method=RequestMethod.GET)
	@ResponseBody
	public MoviesResponse logined(HttpSession session){
        String requestId = UUID.randomUUID().toString();
        this.logger.info("[/Login/logined] Request Parameters: sessionId={}, requestId={}",session.getId(),requestId);
        MoviesResponse result = new MoviesResponse();

		try{
            // Get the information from cache.
            User user = this.userLoginService.checkLogined(session.getId());
            if(user == null){
                result = buildResponse(ResponseTypeEnum.USER_NOT_LOGINED,requestId);
            }else{
                result = buildResponse(ResponseTypeEnum.SUCCESS,requestId);
                result.setData(user);
            }
        }catch (Exception e){
		    this.logger.error("[/Login/logined] Exception: "+e.getMessage() +", requestId="+requestId,e);
		    result = buildResponse(ResponseTypeEnum.SYSTEM_ERROR,requestId);
        }

		this.logger.info("[/Login/logined] Response: {}",result);

		return result;
	}
	
	/**
	 * 处理用户登录请求
	 * @author Fangwei_Cai
	 * @time since 2016年5月1日 下午11:03:04
	 * @param rsaVO
	 * @return
	 */
	@RequestMapping(value="/login", method=RequestMethod.POST)
	@ResponseBody
	public MoviesResponse login(HttpSession session, RsaVO rsaVO){
	    String requestId = UUID.randomUUID().toString();
		this.logger.info("[/Login/login] Request Parameters: rsaVO={}, sessionId={}, requestId={}",rsaVO,session.getId(),requestId);
        MoviesResponse result = new MoviesResponse();
        User user = null;

		try{
			String decoded = RSA.decodeBase64String((PrivateKey) RSAKeyPairs.publicPrivateKeys[1].get(rsaVO.getV()),rsaVO.getData());
			Gson gson = new Gson();
			User decodedUser = gson.fromJson(decoded,User.class);
			this.logger.info("[/Login/login] Decoded: decodedUser={}, requestId={}",decoded,requestId);

			user = userLoginService.userLogin(session.getId(),decodedUser.getUsername(),decodedUser.getPassword(),requestId);
		}catch(Exception e){
			this.logger.info("[/Login/login] Exception: " + e.getMessage() + ", requestId="+requestId,e);
		}

		if(user != null){
			result = buildResponse(ResponseTypeEnum.SUCCESS,requestId);
			result.setData(user);
		}else{
			result = buildResponse(ResponseTypeEnum.USER_NOT_EXISTS,requestId);
		}

		this.logger.info("[/Login/login] Response: {}",result);

		return result;
	}

	/**
	 * @author Fangwei_Cai
	 * @time since 2016年5月31日 下午3:13:36
	 * @param session
	 * @return
	 */
	@RequestMapping("/logout")
	@ResponseBody
	public MoviesResponse userLogout(HttpSession session){
	    String requestId = UUID.randomUUID().toString();
	    this.logger.info("[/Login/logout] Request Parameters: sessionId={}, requestId={}", session.getId(),requestId);
		session.invalidate();

		return buildResponse(ResponseTypeEnum.SUCCESS,requestId);
	}
}
