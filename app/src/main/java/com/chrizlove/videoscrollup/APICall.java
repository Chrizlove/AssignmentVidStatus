package com.chrizlove.videoscrollup;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APICall {
    @GET("app_api/index.php?p=showAllVideos")
    Call<VideoAPIData> getVideos();
}
