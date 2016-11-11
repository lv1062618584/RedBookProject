package com.example.john.myapplication.bean;

import org.json.JSONObject;

/**
 * Created by lvchenguang on 2016/10/18.
 */
public class Find_VP_1 {
    private String image;
    public void setJSONObject(JSONObject jsonObject){
        this.image=jsonObject.optString("image");


    }
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
