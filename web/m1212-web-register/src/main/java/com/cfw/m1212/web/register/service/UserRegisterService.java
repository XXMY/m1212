package com.cfw.m1212.web.register.service;

import com.cfw.m1212.api.UserService;
import com.cfw.m1212.model.User;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Fangwei_Cai
 * @time since 2016年3月26日 下午8:07:16
 */
@Service("registerServiceImpl")
public class UserRegisterService {

	private Log logger = LogFactory.getLog(UserRegisterService.class);

	@Autowired
	private UserService remoteUserService;
	
	/**
	 * @author fwCai
	 * @since 2016.03.26 20:12
	 */
    public boolean userExists(String username) {
		try {
			return this.remoteUserService.userExists(username);
		} catch (Exception e) {
			this.logger.error(e.getMessage(),e);
		}
		return false;
	}

	/**
	 * @author fwCai
	 * @since 2016.03.27 10:11
	 */
	public boolean register(User user) {
		try {
			return this.remoteUserService.register(user);
		} catch (Exception e) {
			this.logger.error(e.getMessage(),e);
		}
		return false;
	}


}
