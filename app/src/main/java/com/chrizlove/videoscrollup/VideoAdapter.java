package com.chrizlove.videoscrollup;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.ui.AspectRatioFrameLayout;
import com.google.android.exoplayer2.ui.PlayerView;

import java.util.ArrayList;

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.VideoViewHolder> {

    ArrayList<VideoModel> videos;
    SimpleExoPlayer simpleExoPlayer;

    public VideoAdapter(ArrayList<VideoModel> videos) {
        this.videos = videos;
    }

    @NonNull
    @Override
    public VideoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.video_lyt,parent,false);
        return new VideoViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull VideoViewHolder holder, int position) {
    holder.setData(videos.get(position));
    }

    @Override
    public int getItemCount() {
        return videos.size();
    }

    class VideoViewHolder extends RecyclerView.ViewHolder {

        PlayerView playerview;
        TextView title,desc;

        public VideoViewHolder(@NonNull View itemView) {
            super(itemView);

            playerview = itemView.findViewById(R.id.playerView);
            title = itemView.findViewById(R.id.titleTextView);
            desc = itemView.findViewById(R.id.descTextView);
        }
        void setData(VideoModel videoModel)
        {
            simpleExoPlayer = new SimpleExoPlayer.Builder(itemView.getContext()).build();
            playerview.setPlayer(simpleExoPlayer);

            title.setText(videoModel.getUser_info().getTitle());
            desc.setText(videoModel.getDesc());
            MediaItem mediaItem = MediaItem.fromUri(videoModel.getUrl());
            simpleExoPlayer.setRepeatMode(Player.REPEAT_MODE_ONE);
            playerview.setUseController(false);
            //making the video fit the entire screen
            playerview.setResizeMode(AspectRatioFrameLayout.RESIZE_MODE_FILL);
            simpleExoPlayer.setVideoScalingMode(C.VIDEO_SCALING_MODE_SCALE_TO_FIT_WITH_CROPPING);
            simpleExoPlayer.addMediaItem(mediaItem);
            simpleExoPlayer.setPlayWhenReady(true);
                simpleExoPlayer.prepare();
        }
    }

}
