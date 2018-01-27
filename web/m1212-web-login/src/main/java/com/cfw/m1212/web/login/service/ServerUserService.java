package com.cfw.m1212.web.login.service;

import com.cfw.m1212.model.User;
import com.cfw.m1212.server.commons.bo.ServerResponseBO;
import com.cfw.m1212.server.commons.controller.ServerUserControllerInterface;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "m1212-server-user")
public interface ServerUserService extends ServerUserControllerInterface {

    @Override
    @RequestMapping("/server/user/getBriefInfo")
    ServerResponseBO getBriefInfo(String username, String requestId);

    @Override
    @RequestMapping("/server/user/getBriefInfoWithPassword")
    ServerResponseBO getBriefInfoWithPassword(String username, String password, String requestId);

    @Override
    @RequestMapping(value = "/server/user/getBriefInfo",method = RequestMethod.POST)
    ServerResponseBO modifyUsersInfo(User newUser, String requestId);

    @Override
    @RequestMapping("/server/user/userExists")
    ServerResponseBO userExists(String userName, String requestId);

    @Override
    @RequestMapping(value = "/server/user/register",method = RequestMethod.POST)
    ServerResponseBO register(User user, String requestId);
}
