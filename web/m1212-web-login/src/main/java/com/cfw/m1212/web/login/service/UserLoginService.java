package com.cfw.m1212.web.login.service;

import com.cfw.m1212.model.User;
import com.cfw.m1212.server.commons.bo.ServerResponseBO;
import com.cfw.m1212.server.commons.enums.RedisKeyEnum;
import com.cfw.m1212.server.commons.enums.ResponseTypeEnum;
import com.cfw.plugins.redis.CRedis;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.concurrent.TimeUnit;

/**
 * @author Fangwei_Cai
 * @time since 2016年3月26日 下午8:07:16
 */
@Service("userLoginService")
public class UserLoginService {
	private Logger logger = LoggerFactory.getLogger(UserLoginService.class);

	@Autowired
	private ServerUserService serverUserService;

	@Autowired
	private CRedis redis;

	/**
	 * User login.<br/>
	 * Check whether username and password valid.
	 *
	 * @param sessionId
	 * @param username
	 * @param password
	 * @return true if valid, otherwise false.
	 * @author CaiFangwei
	 * @time since 2017-3-12 16:31:58
	 */
	public User userLogin(String sessionId, String username, String password, String requestId) {
		if(StringUtils.isEmpty(username) || StringUtils.isEmpty(password))
			return null;

		// Verify and get user's information.
		User user = this.getBriefInfo(username,password,requestId);
		if(user != null){
			// Cache with 5 hours.
			// Use session id to cache.
			Gson gson = new Gson();
			redis.set(String.format(RedisKeyEnum.USER_LOGIN_CACHE.key,sessionId),gson.toJson(user),5L, TimeUnit.HOURS);
			return user;
		}

		return null;
	}

	/**
	 * Check whether user logined.</br>
	 *
	 * @param sessionId
	 * @return
	 */
	public User checkLogined(String sessionId) {
		String cache = redis.get(String.format(RedisKeyEnum.USER_LOGIN_CACHE.key,sessionId));
		Gson gson = new Gson();

		return gson.fromJson(cache,User.class);
	}
	/**
	 * Get user's brief information through user's name and password
	 *
	 * @param username
	 * @param password
	 * @return Brief information of user.
	 * @author CaiFangwei
	 * @time since 2017-3-12 16:34:17
	 */
	private User getBriefInfo(String username, String password, String requestId) {
		if(StringUtils.isEmpty(username) || StringUtils.isEmpty(password))
			return null;

		// Call remote procedure.
		try {
		    ServerResponseBO response = serverUserService.getBriefInfoWithPassword(username,password,requestId);
		    if(response != null && response.getCode() == ResponseTypeEnum.SUCCESS.getType())
		    	return (User) response.getData();
		} catch (Exception e) {
            this.logger.error(e.getMessage(),e);
		}

		return null;
	}
}
