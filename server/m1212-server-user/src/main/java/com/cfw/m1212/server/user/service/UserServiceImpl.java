package com.cfw.m1212.server.user.service;

import com.cfw.m1212.api.UserService;
import com.cfw.m1212.model.User;
import com.cfw.m1212.server.commons.enums.AccountTypeEnum;
import com.cfw.m1212.server.user.dao.UsersDao;
import com.cfw.m1212.server.user.util.UniqueGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * @author Fangwei_Cai
 * @time since 2016年3月26日 下午8:07:16
 */
@Service("userService")
//@CRpcService
public class UserServiceImpl implements UserService {

	@Autowired
	private UniqueGenerator keyGenerator;


	@Autowired
	private UsersDao usersDaoImpl;

	/**
	 * Get user's brief information through user's name
	 *
	 * @param username
	 * @return Brief information of user.
	 * @author CaiFangwei
	 * @time since 2017-3-12 16:09:53
	 */
	@Override
	public User getBriefInfo(String username) {
		if(StringUtils.isEmpty(username))
			return null;

		return this.usersDaoImpl.selectUserByName(username);
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
	@Override
	public User getBriefInfo(String username, String password) {
		if(StringUtils.isEmpty(username) || StringUtils.isEmpty(password))
			return null;

		return this.usersDaoImpl.selectUserInBrief(username,password);
	}


	/**
	 * @author fwCai
	 * @since 2016.06.26 20:13
	 */
	@Override
	public boolean modifyUsersInfo(User newUser) {
		return usersDaoImpl.updateUser(newUser) > 0;
	}

	/**
	 * Check whether user exists.
	 *
	 * @param userName
	 * @author Fangwei_Cai
	 * @time since 2016年3月26日 下午7:38:17
	 */
	@Override
	public boolean userExists(String userName) {
		return usersDaoImpl.selectUserByName(userName) != null;
	}

	/**
	 * @param user
	 * @author Fangwei_Cai
	 * @time since 2016年3月27日 上午10:05:11
	 */
	@Override
	public boolean register(User user) {
		boolean userExists = userExists(user.getUsername());
		if(!userExists){
			user.setUserKey(keyGenerator.newUserKey(AccountTypeEnum.MOVIE));

			return usersDaoImpl.addUser(user) > 0;
		}

		return false;
	}
}
