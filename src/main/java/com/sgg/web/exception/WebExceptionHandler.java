package com.sgg.web.exception;

import com.sgg.web.enumeration.MessageCodeEnum;
import com.sgg.web.response.ResCode;
import com.sgg.web.response.ResResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@ControllerAdvice
public class WebExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResResult webExceptionHandler(Exception e, HttpServletRequest request){
        WebException ex;
        if(e instanceof WebException){
            ex = (WebException)e;
        }else {
            log.error("terminal error",e);
            ex = new WebException(MessageCodeEnum.SERVICE_TERMINAL_ERROR);
        }
        return ex.getResResult();
    }

}
