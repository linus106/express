package com.linus.express.order.bean;

import org.springframework.http.HttpStatus;

/**
 * @Author wangxiangyu
 * @Date 2019/7/25 21:15
 * @Description TODO
 */
public enum ResultCode {

    OK(200, "成功", HttpStatus.OK.value()),
    ERROR_PARAM(400, "请求参数不合法", HttpStatus.BAD_REQUEST.value()),
    UNAUTHORIZED(401, "认证失败或未认证", HttpStatus.UNAUTHORIZED.value()),
    FORBIDDEN(403, "无权限访问", HttpStatus.FORBIDDEN.value()),
    INTERNAL_SERVER_ERROR(500, "服务器内部错误", HttpStatus.INTERNAL_SERVER_ERROR.value())
    ;
    private int code;
    private String desc;
    private int httpStatus;

    ResultCode(int code, String desc, int httpStatus) {
        this.code = code;
        this.desc = desc;
        this.httpStatus = httpStatus;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public int getHttpStatus() {
        return httpStatus;
    }
}
