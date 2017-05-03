package com.androidtutorialpoint.androidspeechtotexttutorial;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.speech.RecognizerIntent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Button;
import android.media.MediaPlayer;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

import com.androidtutorialpoint.androidspeechtotexttutorial.NetworkPost;

public class MainActivity extends AppCompatActivity {

    private TextView voiceInput;
    private TextView speakButton;
    private ImageButton options;
    private final int REQ_CODE_SPEECH_INPUT = 100;
    private Button playButton;
    private String emotion = "";

    private Context mContext = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homepage);

        voiceInput = (TextView) findViewById(R.id.voiceInput);

        speakButton = (TextView) findViewById(R.id.btnSpeak);
        speakButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                askSpeechInput();
            }
        });

        playButton = (Button) findViewById(R.id.playButton);
        playButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //playSong();
                goToPlayMusic();
            }
        });
        options = (ImageButton) findViewById(R.id.options);
        options.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //go to optionspage
                goTomoreActivity();

            }
        });
    }

    // Play Song
    private void playSong() {
        System.out.println("playing song");
        //MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.starboy);
        //mediaPlayer.start();
    }

    // Showing google speech input dialog
    private void askSpeechInput() {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT,
                "Hi speak something");
        try {
            startActivityForResult(intent, REQ_CODE_SPEECH_INPUT);
        } catch (ActivityNotFoundException a) {

        }
    }

    // Receiving speech input

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case REQ_CODE_SPEECH_INPUT: {
                if (resultCode == RESULT_OK && null != data) {

                    ArrayList<String> result = data
                            .getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    //voiceInput.setText(result.get(0));
                    android.util.Log.d("test", "sdsd");
                    Toast.makeText(mContext, "Anaylyzing emotion...", Toast.LENGTH_SHORT);

                    NetworkPost net = new NetworkPost(result.get(0));
                    Thread networkThread = new Thread(net);
                    networkThread.start();
                    try {
                        networkThread.join();
                    }
                    catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    String emo = net.get_emotion();
                    emotion = new String(emo);

                    System.out.println(emo);
                    voiceInput.setText("Emotion Identified - " + emo);
                    goToPlayMusic();
                }
                break;
            }

        }
    }


    // go to play music activity
    private void goToPlayMusic() {
        Intent intent = new Intent(this, PlayMusicActivity.class);
        intent.putExtra("emotion", this.emotion);
        startActivity(intent);
    }

    //go to moreActivity
    private void goTomoreActivity() {
        Intent intent = new Intent(this, moreActivity.class);
        startActivity(intent);
    }

}
