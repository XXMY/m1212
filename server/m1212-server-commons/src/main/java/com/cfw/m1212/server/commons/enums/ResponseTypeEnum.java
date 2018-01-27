package com.cfw.m1212.server.commons.enums;

public enum ResponseTypeEnum {

    SUCCESS(0,"SUCCESS"),
    SERVER_ERROR(-100,"SERVER_ERROR"),
    PARAMETER_WRONG(-101,"PARAMETER_WRONG"),
    ;

    public int type;
    public String desc;

    ResponseTypeEnum(int type, String desc){
        this.type = type;
        this.desc = desc;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
