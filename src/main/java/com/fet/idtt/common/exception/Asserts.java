package com.fet.idtt.common.exception;


import com.fet.idtt.common.api.IErrorCode;

/**
 * @Author : Kevin Chang
 * @create 2023/9/11 上午9:27
 */
public class Asserts {
    public static void fail(String message) {
        throw new ApiException(message);
    }

    public static void fail(IErrorCode errorCode) {
        throw new ApiException(errorCode);
    }
}
