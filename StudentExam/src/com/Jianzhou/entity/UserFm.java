package com.Jianzhou.entity;

/**
 * @ClassName UserFm
 * @Description TODO
 * @Author
 * @Date 2021/3/14
 **/
public class UserFm {
    private int id;
    private String userName;
    private String psd;
    private String email;
    private String gender;

    /**
     * 给检测用户登录用的
     * @param userName
     * @param psd
     */
    public UserFm(String userName, String psd) {
        this.userName = userName;
        this.psd = psd;
    }

    public UserFm(String userName, String psd, String email, String gender) {
        this.userName = userName;
        this.psd = psd;
        this.email = email;
        this.gender = gender;
    }

    public UserFm(int id, String userName, String psd, String email, String gender) {
        this.id = id;
        this.userName = userName;
        this.psd = psd;
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

    public String getPsd() {
        return psd;
    }

    public void setPsd(String psd) {
        this.psd = psd;
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
