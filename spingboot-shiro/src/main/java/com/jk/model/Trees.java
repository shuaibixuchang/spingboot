package com.jk.model;

import java.io.Serializable;
import java.util.List;

public class Trees implements Serializable {

    private static final long serialVersionUID = -2749650892316788576L;
    private Integer id;

    private String url;

    private String text;

    private Integer pid;

    private boolean checked = false;

    private String textname;

    private String temp;

    private String power;

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public String getTextname() {
        return textname;
    }

    public void setTextname(String textname) {
        this.textname = textname;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    private List<Trees> children;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text == null ? null : text.trim();
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public List<Trees> getChildren() {
        return children;
    }

    public void setChildren(List<Trees> children) {
        this.children = children;
    }
}