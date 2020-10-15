package com.sgg.web.response;

import lombok.Data;

@Data
public class ResCode extends ResBase {

    private int code;
    private String message;

    public ResCode(int code,String message){
        this.code = code;
        this.message = message;
    }
}
