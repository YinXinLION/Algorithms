package com.lion.java8.generic;

public enum  OrderEnum implements AllEnum{
    FINISH(1, "FINISH");

    public int code;
    public String desc;

    OrderEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
