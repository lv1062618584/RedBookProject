package com.example.john.myapplication.bean;

import java.util.List;

/**
 * Created by lvchenguang on 2016/10/18.
 */
public class FindRemen {
    private String name;
    private String total;
    private String fans;
    private List<String>  list_img;
    private FindRemen_uesr list_user;



    public List<String> getList_img() {
        return list_img;
    }

    public void setList_img(List<String> list_img) {
        this.list_img = list_img;
    }

    public FindRemen_uesr getList_user() {
        return list_user;
    }

    public void setList_user(FindRemen_uesr list_user) {
        this.list_user = list_user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFans() {
        return fans;
    }

    public void setFans(String fans) {
        this.fans = fans;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }
}
