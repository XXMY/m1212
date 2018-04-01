package com.cfw.m1212.web.register.service;

import com.cfw.m1212.model.db.User;
import com.cfw.m1212.model.response.ServerResponseBO;
import com.cfw.m1212.server.commons.enums.ResponseTypeEnum;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Fangwei_Cai
 * @time since 2016年3月26日 下午8:07:16
 */
@Service("registerServiceImpl")
public class UserRegisterService {

	@Resource
	private ServerUserService serverUserService;
	
	/**
	 * @author fwCai
	 * @since 2016.03.26 20:12
	 */
    public boolean userExists(String username,String requestId) {
		ServerResponseBO<Boolean> result = this.serverUserService.userExists(username,requestId);
		if(result != null && result.getCode() == ResponseTypeEnum.SUCCESS.getType()){
			return result.getData();
		}

		return false;
	}

	/**
	 * @author fwCai
	 * @since 2016.03.27 10:11
	 */
	public boolean register(User user, String requestId) {
		ServerResponseBO<Boolean> result = this.serverUserService.register(user,requestId);
		if(result != null && result.getCode() == ResponseTypeEnum.SUCCESS.getType()){
			return result.getData();
		}

		return false;
	}


}
