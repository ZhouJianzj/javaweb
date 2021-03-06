package com.jianzhou.entity;

/**
 * @ClassName User
 * @Description TODO
 * @Author ZhouJian
 * @Date 2021/3/6
 **/
public class UserFrm {
    private int id;
    private String userName;
    private String pwd;
    private String email;
    private String gender;

    public UserFrm() {
    }

    public UserFrm(int id, String userName, String pwd, String email, String gender) {
        this.id = id;
        this.userName = userName;
        this.pwd = pwd;
        this.email = email;
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
