package com.sgg.web.response;

import com.sgg.web.enumeration.MessageCodeEnum;
import lombok.Data;

@Data
public class ResResult<E> extends ResBase{

    private int code;
    private String message;
    private E result;

    public ResResult(int code, String message){
        this.code = code;
        this.message = message;
        this.result = null;
    }


    public ResResult(MessageCodeEnum messageCodeEnum){
        this.code = messageCodeEnum.getCode();
        this.message = messageCodeEnum.getMessage();
        this.result = null;
    }

    public ResResult(MessageCodeEnum messageCodeEnum,E result){
        this.code = messageCodeEnum.getCode();
        this.message = messageCodeEnum.getMessage();
        this.result = result;
    }
}
