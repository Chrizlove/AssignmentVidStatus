package com.chrizlove.videoscrollup;

import com.google.gson.annotations.SerializedName;

public class UserInfo {
    @SerializedName("username")
    String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public UserInfo(String title) {
        this.title = title;
    }
}
