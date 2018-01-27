package com.cfw.m1212.web.commons.controller;

import com.cfw.m1212.web.commons.enums.ResponseTypeEnum;
import com.cfw.m1212.web.commons.vo.MoviesResponse;

/**
 * @author Fangwei_Cai
 * @time since 2016年4月18日 下午1:54:55
 */
public abstract class BaseController {

	/**
	 * Build a http response.
	 * @param code
	 * @param message
	 * @return
	 *
	 * @author CaiFangwei
	 * @time since 2017-3-11 19:49:21
	 */
	public MoviesResponse buildResponse(int code, String message,String requestId){
		MoviesResponse moviesResponse = new MoviesResponse(code,message,requestId);
		
		return moviesResponse;
	}

	public MoviesResponse buildResponse(ResponseTypeEnum type,String requestId){

		return this.buildResponse(type.getCode(),type.getDescription(),requestId);
	}
}
