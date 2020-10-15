package com.sgg.web.controller;

import com.sgg.web.enumeration.MessageCodeEnum;
import com.sgg.web.exception.WebException;
import com.sgg.web.model.User;
import com.sgg.web.response.ResResult;
import com.sgg.web.service.UserService;
import com.sgg.web.util.JWTUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping("/user")
@Api(tags = "用户")
@RestController
public class UserController extends BaseController{

    @Autowired
    private UserService userService;

    @ApiOperation("新增用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userName",value = "用户名",required = true),
            @ApiImplicitParam(name = "userPassword",value = "密码",required = true)
    })
    @PostMapping("/register")
    public ResResult register(User user){
        ResResult resResult;
        try {
            if(StringUtils.isBlank(user.getUserName()) || StringUtils.isBlank(user.getUserPassword())){
                log.error("[register] error",user.getUserName(),user.getUserPassword());
                throw new WebException(MessageCodeEnum.PARAM_ERROR);
            }
            userService.addUser(user);
            resResult = new ResResult<>(MessageCodeEnum.SUCCESS, JWTUtils.createToken(user.getUserName(),user.getUserPassword()));
        }catch (WebException e){
            log.error(e.getMessage());
            resResult = e.getResResult();
        }catch (Exception e){
            log.error(e.getMessage(),e);
            resResult = new ResResult(MessageCodeEnum.SERVICE_TERMINAL_ERROR);
        }
        return resResult;
    }

    @ApiOperation("登录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userName",value = "用户名",defaultValue = "system",required = true),
            @ApiImplicitParam(name = "password",value = "密码",defaultValue = "song1130",required = true)
    })
    @PostMapping("/login")
    public ResResult login(String userName,String password){
        ResResult resResult;
        try {
            if(StringUtils.isBlank(userName) || StringUtils.isBlank(password)){
                log.error("[login] error",userName,password);
                throw new WebException(MessageCodeEnum.PARAM_ERROR);
            }
            userService.login(userName,password);
            resResult = new ResResult<>(MessageCodeEnum.SUCCESS,JWTUtils.createToken(userName,password));
        }catch (WebException e){
            log.error(e.getMessage());
            resResult = e.getResResult();
        }catch (Exception e){
            log.error(e.getMessage(),e);
            resResult = new ResResult(MessageCodeEnum.SERVICE_TERMINAL_ERROR);
        }
        return resResult;
    }

}
