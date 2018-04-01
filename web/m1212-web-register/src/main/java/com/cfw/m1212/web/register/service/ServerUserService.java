package com.cfw.m1212.web.register.service;

import com.cfw.m1212.feign.user.ServerUserControllerFeign;
import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient(value = "m1212-server-user")
public interface ServerUserService extends ServerUserControllerFeign {}
