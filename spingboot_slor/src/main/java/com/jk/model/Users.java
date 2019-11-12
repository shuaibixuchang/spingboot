package com.jk.model;

import java.io.Serializable;

public class Users implements Serializable {


    private static final long serialVersionUID = 1083826992818097853L;


    private Integer userid;

    private String username;

    private Integer usersex;

    private String usershow;

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public Integer getUsersex() {
        return usersex;
    }

    public void setUsersex(Integer usersex) {
        this.usersex = usersex;
    }

    public String getUsershow() {
        return usershow;
    }

    public void setUsershow(String usershow) {
        this.usershow = usershow == null ? null : usershow.trim();
    }
}