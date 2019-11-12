package com.jk.model;

import java.io.Serializable;

public class Roles implements Serializable {
    private static final long serialVersionUID = 7668258056479507184L;
    private Integer roleid;

    private String rolename;

    private String checkz;

    public String getCheckz() {
        return checkz;
    }

    public void setCheckz(String checkz) {
        this.checkz = checkz;
    }

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename == null ? null : rolename.trim();
    }
}