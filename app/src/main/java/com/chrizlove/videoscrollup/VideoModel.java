package com.chrizlove.videoscrollup;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class VideoModel {

    @SerializedName("video")
    String url;
    //@SerializedName("username")
    //String title;
    @SerializedName("description")
    String desc;
    //@SerializedName("user_info")
    //ArrayList<UserInfo> user_info;

    //public ArrayList<UserInfo> getUser_info() {
        //return user_info;
   // }

    //public void setUser_info(ArrayList<UserInfo> user_info) {
    //    this.user_info = user_info;
    //}

    public VideoModel(String url, String desc) {
        this.url = url;
        this.desc = desc;
       // this.user_info = user_info;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
