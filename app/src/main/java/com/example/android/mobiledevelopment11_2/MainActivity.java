package com.example.android.mobiledevelopment11_2;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private MediaPlayer mPlayer;
    private Button mLagu1, mLagu2;

    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mLagu1 = findViewById(R.id.button_lagu1);
        mLagu2 = findViewById(R.id.button_lagu2);

        mLagu1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                releaseMediaPlayer();
                mPlayer = MediaPlayer.create(MainActivity.this, R.raw.lagu);
                mPlayer.setOnCompletionListener(completionListener);
                mPlayer.start();
            }
        });

        mLagu2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                releaseMediaPlayer();
                mPlayer = MediaPlayer.create(MainActivity.this, R.raw.lagu2);
                mPlayer.setOnCompletionListener(completionListener);
                mPlayer.start();
            }
        });
    }

    MediaPlayer.OnCompletionListener completionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            releaseMediaPlayer();
        }
    };

    private void releaseMediaPlayer() {
        if (mPlayer != null) {
            mPlayer.release();
            mPlayer = null;
        }
    }
}
