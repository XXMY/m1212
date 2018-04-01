package com.cfw.m1212.server.user.controller;

import com.cfw.m1212.api.UserService;
import com.cfw.m1212.feign.user.ServerUserControllerFeign;
import com.cfw.m1212.model.db.User;
import com.cfw.m1212.model.response.ServerResponseBO;
import com.cfw.m1212.server.commons.enums.ResponseTypeEnum;
import com.google.common.base.Preconditions;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class UserController implements ServerUserControllerFeign {
    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @Resource(name = "userService")
    private UserService userService;

    @Override
    public ServerResponseBO<User> getBriefInfo(String username,String requestId) {
        ServerResponseBO<User> response = new ServerResponseBO<User>();
        response.setRequestId(requestId);
        this.logger.info("[/server/user/getBriefInfo] Request Parameters: username={}, requestId={}",username,requestId);
        try{
            Preconditions.checkArgument(StringUtils.isNotEmpty(username),"Wrong username");
            User user = this.userService.getBriefInfo(username);

            response.setCode(ResponseTypeEnum.SUCCESS.getType());
            response.setDescription(ResponseTypeEnum.SUCCESS.getDesc());
            response.setData(user);
        }catch (IllegalArgumentException e){
            this.logger.warn("[/server/user/getBriefInfo] IllegalArgumentException, {}",e.getMessage());

            response.setCode(ResponseTypeEnum.PARAMETER_WRONG.getType());
            response.setDescription(e.getMessage());
        }catch (Exception e){
            this.logger.error(e.getMessage(),e);

            response.setCode(ResponseTypeEnum.SERVER_ERROR.getType());
            response.setDescription(e.getMessage());
        }

        this.logger.info("[/server/user/getBriefInfo] Response: {}", response);

        return response;
    }

    @Override
    public ServerResponseBO<User> getBriefInfoWithPassword(String username, String password, String requestId) {
        ServerResponseBO<User> response = new ServerResponseBO<User>();
        response.setRequestId(requestId);
        this.logger.info("[/server/user/getBriefInfo] Request Parameters: username={}, password={}, requestId={}",username,password,requestId);
        try{
            Preconditions.checkArgument(StringUtils.isNotEmpty(username),"Wrong username");
            Preconditions.checkArgument(StringUtils.isNotEmpty(password),"Wrong password");
            User user = this.userService.getBriefInfo(username,password);

            response.setCode(ResponseTypeEnum.SUCCESS.getType());
            response.setDescription(ResponseTypeEnum.SUCCESS.getDesc());
            response.setData(user);
        }catch (IllegalArgumentException e){
            this.logger.warn("[/server/user/getBriefInfo] IllegalArgumentException, {}",e.getMessage());

            response.setCode(ResponseTypeEnum.PARAMETER_WRONG.getType());
            response.setDescription(e.getMessage());
        }catch (Exception e){
            this.logger.error(e.getMessage(),e);

            response.setCode(ResponseTypeEnum.SERVER_ERROR.getType());
            response.setDescription(e.getMessage());
        }

        this.logger.info("[/server/user/getBriefInfo] Response: {}", response);

        return response;
    }

    @Override
    public ServerResponseBO<Boolean> modifyUsersInfo(User newUser, String requestId) {
        ServerResponseBO<Boolean> response = new ServerResponseBO<Boolean>();
        response.setRequestId(requestId);
        this.logger.info("[/server/user/modifyUsersInfo] Request Parameters: newUser={}, requestId={}",newUser,requestId);
        try{
            Preconditions.checkArgument(newUser != null,"Wrong newUser");
            boolean result = this.userService.modifyUsersInfo(newUser);

            response.setCode(ResponseTypeEnum.SUCCESS.getType());
            response.setDescription(ResponseTypeEnum.SUCCESS.getDesc());
            response.setData(result);
        }catch (IllegalArgumentException e){
            this.logger.warn("[/server/user/modifyUsersInfo] IllegalArgumentException, {}",e.getMessage());

            response.setCode(ResponseTypeEnum.PARAMETER_WRONG.getType());
            response.setDescription(e.getMessage());
        }catch (Exception e){
            this.logger.error(e.getMessage(),e);

            response.setCode(ResponseTypeEnum.SERVER_ERROR.getType());
            response.setDescription(e.getMessage());
        }

        this.logger.info("[/server/user/modifyUsersInfo] Response: {}", response);

        return response;
    }

    @Override
    public ServerResponseBO<Boolean> userExists(String userName, String requestId) {
        ServerResponseBO<Boolean> response = new ServerResponseBO<Boolean>();
        response.setRequestId(requestId);
        this.logger.info("[/server/user/userExists] Request Parameters: userName={}, requestId={}",userName,requestId);
        try{
            Preconditions.checkArgument(StringUtils.isNotEmpty(userName),"Wrong userName");
            boolean result = this.userService.userExists(userName);

            response.setCode(ResponseTypeEnum.SUCCESS.getType());
            response.setDescription(ResponseTypeEnum.SUCCESS.getDesc());
            response.setData(result);
        }catch (IllegalArgumentException e){
            this.logger.warn("[/server/user/userExists] IllegalArgumentException, {}",e.getMessage());

            response.setCode(ResponseTypeEnum.PARAMETER_WRONG.getType());
            response.setDescription(e.getMessage());
        }catch (Exception e){
            this.logger.error(e.getMessage(),e);

            response.setCode(ResponseTypeEnum.SERVER_ERROR.getType());
            response.setDescription(e.getMessage());
        }

        this.logger.info("[/server/user/userExists] Response: {}", response);

        return response;
    }

    @Override
    public ServerResponseBO<Boolean> register(User user, String requestId) {
        ServerResponseBO<Boolean> response = new ServerResponseBO<Boolean>();
        response.setRequestId(requestId);
        this.logger.info("[/server/user/register] Request Parameters: user={}, requestId={}",user,requestId);
        try{
            Preconditions.checkArgument(user != null,"Wrong user");
            boolean result = this.userService.register(user);

            response.setCode(ResponseTypeEnum.SUCCESS.getType());
            response.setDescription(ResponseTypeEnum.SUCCESS.getDesc());
            response.setData(result);
        }catch (IllegalArgumentException e){
            this.logger.warn("[/server/user/register] IllegalArgumentException, {}",e.getMessage());

            response.setCode(ResponseTypeEnum.PARAMETER_WRONG.getType());
            response.setDescription(e.getMessage());
        }catch (Exception e){
            this.logger.error(e.getMessage(),e);

            response.setCode(ResponseTypeEnum.SERVER_ERROR.getType());
            response.setDescription(e.getMessage());
        }

        this.logger.info("[/server/user/register] Response: {}", response);

        return response;
    }
}
