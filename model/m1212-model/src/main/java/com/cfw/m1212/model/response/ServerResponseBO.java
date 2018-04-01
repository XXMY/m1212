package com.cfw.m1212.model.response;

import java.io.Serializable;

public class ServerResponseBO<T> implements Serializable {

    private static final long serialVersionUID = 1041872321081567225L;
    private int code;
    private String description;
    private T data;
    private String requestId;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
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
        return "ServerResponseBO{" +
                "code=" + code +
                ", description='" + description + '\'' +
                ", data=" + data +
                ", requestId='" + requestId + '\'' +
                '}';
    }
}
