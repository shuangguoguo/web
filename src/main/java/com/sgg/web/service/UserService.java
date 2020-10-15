package com.sgg.web.service;

import com.sgg.web.model.User;

public interface UserService {


    void addUser(User user);

    void updateUser(User user);

    void deleteUser(int userId);

    void login(String userName,String userPassword);

}
