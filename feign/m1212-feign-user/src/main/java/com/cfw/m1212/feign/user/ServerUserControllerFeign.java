package com.cfw.m1212.feign.user;

import com.cfw.m1212.model.db.User;
import com.cfw.m1212.model.response.ServerResponseBO;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/server/user")
public interface ServerUserControllerFeign {

    @RequestMapping("/getBriefInfo")
    ServerResponseBO<User> getBriefInfo(@RequestParam("username") String username, @RequestParam("requestId") String requestId);

    @RequestMapping("/getBriefInfoWithPassword")
    ServerResponseBO<User> getBriefInfoWithPassword(@RequestParam("username") String username,@RequestParam("password") String password,@RequestParam("requestId") String requestId);

    @RequestMapping(value = "/modifyUsersInfo",method = RequestMethod.POST)
    ServerResponseBO<Boolean> modifyUsersInfo(@RequestParam("newUser")User newUser,@RequestParam("requestId")String requestId);

    @RequestMapping("/userExists")
    ServerResponseBO<Boolean> userExists(@RequestParam("userName")String userName,@RequestParam("requestId")String requestId);

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    ServerResponseBO<Boolean> register(User user, @PathVariable("requestId") String requestId);
}
