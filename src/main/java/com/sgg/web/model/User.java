package com.sgg.web.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 */
public class User implements Serializable {
    /**
     * 用户ID
     */
    private Integer userId;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 密码
     */
    private String userPassword;

    /**
     * 邮箱
     */
    private String userEmail;

    /**
     * 手机号
     */
    private Integer userPhoneNumber;

    /**
     * 头像
     */
    private String userProfilePhoto;

    /**
     * 用户创建时间
     */
    private Date userCreateDate;

    /**
     * 用户修改时间
     */
    private Date userModifyDate;

    private static final long serialVersionUID = 1L;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public Integer getUserPhoneNumber() {
        return userPhoneNumber;
    }

    public void setUserPhoneNumber(Integer userPhoneNumber) {
        this.userPhoneNumber = userPhoneNumber;
    }

    public String getUserProfilePhoto() {
        return userProfilePhoto;
    }

    public void setUserProfilePhoto(String userProfilePhoto) {
        this.userProfilePhoto = userProfilePhoto;
    }

    public Date getUserCreateDate() {
        return userCreateDate;
    }

    public void setUserCreateDate(Date userCreateDate) {
        this.userCreateDate = userCreateDate;
    }

    public Date getUserModifyDate() {
        return userModifyDate;
    }

    public void setUserModifyDate(Date userModifyDate) {
        this.userModifyDate = userModifyDate;
    }
}