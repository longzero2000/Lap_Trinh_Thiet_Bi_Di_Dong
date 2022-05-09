package com.nguyenvanhailong.music_player_app;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    MediaPlayer music;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        music = MediaPlayer.create(this, R.raw.main);
    }
    public void musicplay(View v)
    {
        music.start();
    }

    public void musicpause(View v)
    {
        music.pause();
    }

    public void musicstop(View v)
    {
        music.stop();
        music= MediaPlayer.create(this, R.raw.main);
    }
}