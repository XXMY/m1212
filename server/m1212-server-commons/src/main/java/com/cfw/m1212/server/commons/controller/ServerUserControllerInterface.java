package com.cfw.m1212.server.commons.controller;

import com.cfw.m1212.model.User;
import com.cfw.m1212.server.commons.bo.ServerResponseBO;

public interface ServerUserControllerInterface {

    ServerResponseBO getBriefInfo(String username,String requestId);

    ServerResponseBO getBriefInfoWithPassword(String username, String password,String requestId);

    ServerResponseBO modifyUsersInfo(User newUser,String requestId);

    ServerResponseBO userExists(String userName,String requestId);

    ServerResponseBO register(User user,String requestId);
}
