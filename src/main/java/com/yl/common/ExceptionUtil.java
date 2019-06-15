package com.yl.common;

public class ExceptionUtil {

    // 抛出数组异常
    public static void throwArrayException(String message) throws ArrayException {
        throw new ArrayException(message);
    }

}
