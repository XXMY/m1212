package com.cfw.m1212.server.commons.bo;

public class ServerResponseBO<T> {
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
