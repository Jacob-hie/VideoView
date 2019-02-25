package com.hie2j.videoview;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends Activity {

    private VideoView myVideo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myVideo = findViewById(R.id.my_video);
        myVideo.setVideoPath("/mnt/shared/Other/family.mp4");
        myVideo.setMediaController(new MediaController(MainActivity.this));
        myVideo.start();
    }
}
