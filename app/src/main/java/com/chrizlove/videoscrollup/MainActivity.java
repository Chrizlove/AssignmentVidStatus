package com.chrizlove.videoscrollup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.util.Log;
import android.view.WindowManager;
import android.widget.Toast;
import android.widget.VideoView;

import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.ui.PlayerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    ViewPager2 viewPager2;
    ArrayList<VideoModel> videos, videosSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        viewPager2 = (ViewPager2) findViewById(R.id.viewpagerVideos);
        videos = new ArrayList<>();
        videosSend = new ArrayList<>();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://fatema.takatakind.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        APICall apiCall = retrofit.create(APICall.class);
        Call<VideoAPIData> call = apiCall.getVideos();
        call.enqueue(new Callback<VideoAPIData>() {
            @Override
            public void onResponse(Call<VideoAPIData> call, Response<VideoAPIData> response) {
                videos = response.body().getMsg();
                Log.d("API","Success");
                for(int i=0;i<3;i++)
                {
                    VideoModel videoToAdd = new VideoModel(videos.get(i).getUrl(),videos.get(i).getDesc());
                    videosSend.add(videoToAdd);
                    Log.d("video",videos.get(i).getUrl());
                }
                //(VideoModel video: videos)
            }
            @Override
            public void onFailure(Call<VideoAPIData> call, Throwable t) {
                Log.d("API Fail", t.getMessage());
            }
        });
        viewPager2.setAdapter(new VideoAdapter(videosSend));
    }
}