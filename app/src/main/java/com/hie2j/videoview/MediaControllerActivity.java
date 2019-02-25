package com.hie2j.videoview;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.MediaController;

public class MediaControllerActivity extends Activity implements MediaController.MediaPlayerControl{

    private SurfaceView my_surfaceView;
    private MediaPlayer mediaPlayer;
    private MediaController mediaController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media_controller);
        my_surfaceView = findViewById(R.id.my_surfaceView);
        mediaPlayer = MediaPlayer.create(MediaControllerActivity.this,
                R.raw.family);
        my_surfaceView.getHolder().addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                mediaPlayer.setDisplay(my_surfaceView.getHolder());
                mediaPlayer.start();
            }
            @Override
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {

            }
            @Override
            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {

            }
        });

        mediaController = new MediaController(MediaControllerActivity.this);
        mediaController.setMediaPlayer(MediaControllerActivity.this);
//        mediaController.setAnchorView(findViewById(R.id.root));
        mediaController.setEnabled(true);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        mediaController.show();
        return mediaController.onTouchEvent(event);
    }

    @Override
    public void start() {
        mediaPlayer.start();
    }

    @Override
    public void pause() {
        mediaPlayer.pause();

        // 显示广告
    }

    @Override
    public int getDuration() {
        return mediaPlayer.getDuration();
    }

    @Override
    public int getCurrentPosition() {
        return mediaPlayer.getCurrentPosition();
    }

    @Override
    public void seekTo(int i) {
        mediaPlayer.seekTo(i);
    }

    @Override
    public boolean isPlaying() {
        return mediaPlayer.isPlaying();
    }

    @Override
    public int getBufferPercentage() {
        return 0;
    }

    @Override
    public boolean canPause() {
        return true;
    }

    @Override
    public boolean canSeekBackward() {
        return false;
    }

    @Override
    public boolean canSeekForward() {
        return false;
    }

    @Override
    public int getAudioSessionId() {
        return 0;
    }
}
