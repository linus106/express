package com.linus.express.order.bean;

import lombok.Data;

/**
 * @Author wangxiangyu
 * @Date 2019/7/25 21:13
 * @Description TODO
 */
@Data
public class CommonResponse<T> {

    private boolean success;
    private int code;
    private String message;
    private T data;

    public CommonResponse(boolean success, int code) {
        this.success = success;
        this.code = code;
    }


    public CommonResponse(boolean success, T result) {
        this.success = success;
        this.data = result;
    }

    public CommonResponse(){
    }

    public CommonResponse(boolean success, int resultCode, T result) {
        this.success = success;
        this.code = resultCode;
        this.data = result;
    }

    public CommonResponse(boolean success, int resultCode, String message) {
        this.success = success;
        this.code = resultCode;
        this.message = message;
    }

    public static <T> CommonResponse<T> success(int resultCode, T result) {
        return new CommonResponse(true, resultCode, result);
    }


    public static CommonResponse ok() {
        return new CommonResponse(true, ResultCode.OK.getCode());
    }

    public static <T> CommonResponse<T> ok(T result) {
        return new CommonResponse(true, ResultCode.OK.getCode(), result);
    }

    public static <T> CommonResponse<T> errorParam(String message) {
        return new CommonResponse(false, ResultCode.ERROR_PARAM.getCode(), message);
    }

    public static <T> CommonResponse<T> unAuthorized(String message) {
        return new CommonResponse(false, ResultCode.UNAUTHORIZED.getCode(), message);
    }

    public static <T> CommonResponse<T> fobidden(String message) {
        return new CommonResponse(false, ResultCode.FORBIDDEN.getCode(), message);
    }




}
