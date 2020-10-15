package com.sgg.web.service.impl;

import com.sgg.web.enumeration.MessageCodeEnum;
import com.sgg.web.exception.WebException;
import com.sgg.web.mapper.UserMapper;
import com.sgg.web.model.User;
import com.sgg.web.service.UserService;
import com.sgg.web.util.MD5Utils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void addUser(User user) {
        User user1 = userMapper.queryUserByUserName(user.getUserName());
        if(user1 != null){
            throw new WebException(MessageCodeEnum.USERNAME_HAS_EXIST);
        }
        String MD5UserPassword = MD5Utils.md5(user.getUserPassword());
        user.setUserPassword(MD5UserPassword);
        userMapper.insertSelective(user);
    }

    @Override
    public void updateUser(User user) {

    }

    @Override
    public void deleteUser(int userId) {

    }

    @Override
    public void login(String userName, String userPassword) {
        User user = userMapper.queryUserByUserName(userName);
        if(user == null || !MD5Utils.md5(userPassword).equals(user.getUserPassword())){
            throw new WebException(MessageCodeEnum.USER_LOGIN_ERROR);
        }
    }
}
