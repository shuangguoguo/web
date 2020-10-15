package com.sgg.web.interceptor;

import com.sgg.web.enumeration.MessageCodeEnum;
import com.sgg.web.exception.WebException;
import com.sgg.web.util.JWTUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Slf4j
@Component
public class UserLoginInterceptor extends HandlerInterceptorAdapter {

    @Value("${login.flag}")
    private Boolean loginFlag;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        try {
            if(!loginFlag){
                return true;
            }
            Map map = JWTUtils.verifyToken(request.getHeader("Authorization"));
            if(map != null){
                return true;
            }
        }catch (Exception e){
            log.error("[preHandle] user login intercepter error",e);
        }
        throw  new WebException(MessageCodeEnum.USER_NOT_LOGIN);
    }
}
