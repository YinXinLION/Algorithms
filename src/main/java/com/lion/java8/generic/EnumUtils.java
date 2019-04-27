package com.lion.java8.generic;

public class EnumUtils {

    public static <T extends AllEnum> T getDescByCode(int code, Class<T> tClass) {
        for (T enumConstant : tClass.getEnumConstants()) {
            if (enumConstant.getCode() == code) {
                return enumConstant;
            }
        }
        throw new RuntimeException("false");
    }
}
