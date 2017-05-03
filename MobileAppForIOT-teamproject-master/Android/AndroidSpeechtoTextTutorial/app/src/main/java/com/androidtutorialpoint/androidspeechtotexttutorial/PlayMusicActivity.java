package com.androidtutorialpoint.androidspeechtotexttutorial;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.cleveroad.play_widget.PlayLayout;

public class PlayMusicActivity extends AppCompatActivity {
    private PlayLayout mPlayLayout;
    private Context mContext = this;
    private MediaPlayer mMediaPlayer;
    private TextView mTextView;
    private EmotionToSong mEmotionToSong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_music);

        Intent intent = getIntent();
        final String emotion = intent.getStringExtra("emotion");
        Log.e("PlayMusicActivity", emotion);

        mTextView = (TextView) findViewById(R.id.songTitle);
        mTextView.setText(emotion);

        mEmotionToSong = new EmotionToSong();

        mPlayLayout = (PlayLayout) findViewById(R.id.playLayout);

        mPlayLayout.setOnButtonsClickListener(new PlayLayout.OnButtonsClickListener() {

            @Override
            public void onShuffleClicked() {

            }

            @Override
            public void onSkipPreviousClicked() {

            }

            @Override
            public void onSkipNextClicked() {

            }

            @Override
            public void onRepeatClicked() {

            }

            @Override
            public void onPlayButtonClicked() {
                System.out.println("playing song");

                if (mMediaPlayer == null) {
                    // initialize
                    Song song = mEmotionToSong.getSong(emotion);
                    String fname = song.getFilename();
                    Log.e("fname", fname);
                    String songInfo = song.getSongTitle() + " By " + song.getSinger();
                    mTextView.setText(songInfo);
                    //String fname = "someone_like_you";
                    int resID=getResources().getIdentifier(fname, "raw", getPackageName());
                    mMediaPlayer = MediaPlayer.create(mContext, resID);

                }

                if (mMediaPlayer.isPlaying()) {
                    mMediaPlayer.pause();
                    mPlayLayout.startDismissAnimation();
                } else {
                    mMediaPlayer.start();
                    mPlayLayout.startRevealAnimation();
                }
            }
        });
    }

    @Override

    public void onBackPressed() {
        if (mMediaPlayer != null && mMediaPlayer.isPlaying()) {
            mMediaPlayer.pause();
            mPlayLayout.startDismissAnimation();
        }
        Intent intent = new Intent(mContext, MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mMediaPlayer != null && mMediaPlayer.isPlaying()) {
            mMediaPlayer.pause();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mMediaPlayer != null && mMediaPlayer.isPlaying()) {
            mMediaPlayer.stop();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mMediaPlayer != null && mMediaPlayer.isPlaying()) {
            mMediaPlayer.release();
        }
    }

}
