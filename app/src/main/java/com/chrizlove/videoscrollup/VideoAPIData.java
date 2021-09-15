package com.chrizlove.videoscrollup;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class VideoAPIData{

    //@SerializedName("msg")
    private ArrayList<VideoModel> msg;

    public ArrayList<VideoModel> getMsg() {
        return msg;
    }

    public void setMsg(ArrayList<VideoModel> msg) {
        this.msg = msg;
    }
}
