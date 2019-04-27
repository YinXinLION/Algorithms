package com.lion.java8.generic;

public enum PayEnum implements AllEnum{
    PAY(1, "PAYED");

    public int code;
    public String desc;

    PayEnum(int code, String desc) {
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
