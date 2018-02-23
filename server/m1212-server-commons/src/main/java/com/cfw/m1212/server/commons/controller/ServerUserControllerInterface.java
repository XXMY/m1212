package com.cfw.m1212.server.commons.controller;

import com.cfw.m1212.model.User;
import com.cfw.m1212.server.commons.bo.ServerResponseBO;

public interface ServerUserControllerInterface {

    ServerResponseBO<User> getBriefInfo(String username,String requestId);

    ServerResponseBO<User> getBriefInfoWithPassword(String username, String password,String requestId);

    ServerResponseBO<Boolean> modifyUsersInfo(User newUser,String requestId);

    ServerResponseBO<Boolean> userExists(String userName,String requestId);

    ServerResponseBO<Boolean> register(User user,String requestId);
}
