package com.example.john.myapplication.comment;

/**
 * Created by 徐陈承 on 2016/9/20.
 */
public class APIContent {

     //首页
    public static  String getHomeUrl(){
        return "http://www.xiaohongshu.com/api/sns/v3/homefeed?oid=homefeed_recommend&value=simple&page=1&platform=Android&deviceId=986bf5b0-b1ef-3a15-ba11-1a946d4859e6&versionName=4.10.100&channel=Store360&sid=session.1161509705676028745&lang=zh-CN&t=1477013735&sign=6c2bc4b938204a33d4246a4a09cf4435";
    }

    //发现
    public static String getFindViewPagerURL() {
        return "http://www.xiaohongshu.com/api/sns/v3/explore/banner?mode=bottom_hot_boards&platform=Android&deviceId=986bf5b0-b1ef-3a15-ba11-1a946d4859e6&versionName=4.10.100&channel=Store360&sid=session.1161509705676028745&lang=zh-CN&t=1477014868&sign=8cca7eb42f7cb8dabcab8a354b3acdac";
    }

    public static String getFindReMenZhuanJiURL() {
        return "http://www.xiaohongshu.com/api/sns/v1/board/hot?page=1&platform=Android&deviceId=986bf5b0-b1ef-3a15-ba11-1a946d4859e6&versionName=4.10.100&channel=Store360&sid=session.1161509705676028745&lang=zh-CN&t=1477014868&sign=b520b36359c82a0120efd89644bacf7d";
    }

}
