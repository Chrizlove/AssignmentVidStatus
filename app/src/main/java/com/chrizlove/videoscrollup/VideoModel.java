package com.chrizlove.videoscrollup;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class VideoModel {

    @SerializedName("video")
    String url;
    @SerializedName("description")
    String desc;
    @SerializedName("user_info")
    UserInfo user_info;

    Boolean isPlaying = false;

    public Boolean getPlaying() {
        return isPlaying;
    }

    public void setPlaying(Boolean playing) {
        isPlaying = playing;
    }

    public UserInfo getUser_info() {
        return user_info;
    }

    public void setUser_info(UserInfo user_info) {
        this.user_info = user_info;
    }

    public VideoModel(String url, String desc, UserInfo user_info,Boolean isPlaying) {
        this.url = url;
        this.desc = desc;
        this.user_info = user_info;
        this.isPlaying = isPlaying;
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
