package com.cfw.m1212.web.commons.vo;

import java.util.UUID;

/**
 * @author Fangwei_Cai
 * @time since 2016年4月11日 上午10:32:08
 */
public class MoviesResponse {

	private int code;

	private String message;

	private Object data;

	private String requestId;

	public MoviesResponse() {
		super();
		this.requestId = UUID.randomUUID().toString();
		// TODO Auto-generated constructor stub
	}

	public MoviesResponse(int code, String message) {
		super();
		this.code = code;
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	@Override
	public String toString() {
		return "MoviesResponse{" +
				"code=" + code +
				", message='" + message + '\'' +
				", object=" + data +
				", requestId='" + requestId + '\'' +
				'}';
	}
}
