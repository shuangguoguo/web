package com.sgg.web.enumeration;

public enum MessageCodeEnum {

    SUCCESS(1,"SUCCESS"),
    PARAM_ERROR(11111,"参数错误"),
    USERNAME_HAS_EXIST(10001,"用户名已经存在"),
    USER_NOT_EXIST(10002,"用户名不存在"),
    USER_LOGIN_ERROR(10003,"用户名或密码错误"),
    USER_NOT_LOGIN(10004,"用户尚未登录"),
    SERVICE_TERMINAL_ERROR(90001,"业务处理失败");

    private int code;
    private String message;

    MessageCodeEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage(){
        return message;
    }
}
