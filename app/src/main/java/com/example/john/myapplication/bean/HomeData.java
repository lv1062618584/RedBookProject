package com.example.john.myapplication.bean;

import java.util.List;

/**
 * Created by 徐陈承 on 2016/10/19.
 */

public class HomeData {
    private List<ImageUrl> images_list;
    private String name;
    private String desc;
    private User user;

    public List<ImageUrl> getImages_list() {
        return images_list;
    }

    public void setImages_list(List<ImageUrl> images_list) {
        this.images_list = images_list;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
