package com.sgg.web.exception;

import com.sgg.web.enumeration.MessageCodeEnum;
import com.sgg.web.response.ResCode;
import com.sgg.web.response.ResResult;
import lombok.Data;

@Data
public class WebException extends RuntimeException{

    private int code;
    private String message;


    public WebException(MessageCodeEnum messageCodeEnum){
        this.code = messageCodeEnum.getCode();
        this.message = messageCodeEnum.getMessage();
    }

    public ResResult getResResult(){
        return new ResResult(code,message);
    }

}
