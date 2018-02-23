package com.cfw.m1212.web.login.service;

import com.cfw.m1212.model.User;
import com.cfw.m1212.server.commons.bo.ServerResponseBO;
import com.cfw.m1212.server.commons.controller.ServerUserControllerInterface;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "m1212-server-user")
public interface ServerUserService extends ServerUserControllerInterface {

    @Override
    @RequestMapping("/server/user/getBriefInfo")
    ServerResponseBO<User> getBriefInfo(@RequestParam("username") String username,@RequestParam("requestId") String requestId);

    @Override
    @RequestMapping("/server/user/getBriefInfoWithPassword")
    ServerResponseBO<User> getBriefInfoWithPassword(@RequestParam("username") String username,@RequestParam("password") String password,@RequestParam("requestId") String requestId);

    @Override
    @RequestMapping(value = "/server/user/getBriefInfo",method = RequestMethod.POST)
    ServerResponseBO<Boolean> modifyUsersInfo(@RequestParam("newUser")User newUser,@RequestParam("requestId")String requestId);

    @Override
    @RequestMapping("/server/user/userExists")
    ServerResponseBO<Boolean> userExists(@RequestParam("userName")String userName,@RequestParam("requestId")String requestId);

    @Override
    @RequestMapping(value = "/server/user/register",method = RequestMethod.POST)
    ServerResponseBO<Boolean> register(@RequestParam("user")User user,@RequestParam("requestId")String requestId);
}
