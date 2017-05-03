package com.androidtutorialpoint.androidspeechtotexttutorial;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.TextView;

/**
 * Created by Anupama Josyula on 02-05-2017.
 */

public class homeActivity extends AppCompatActivity {
    private ImageButton happybtn;
    private ImageButton surpbtn;
    private ImageButton sadbtn;
    private ImageButton angrybtn;
    private ImageButton fearbtn;
    private String emotion = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emotions);

        happybtn = (ImageButton) findViewById(R.id.happybtn);
        happybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToplayhappyMusic();
            }
        });

        surpbtn = (ImageButton) findViewById(R.id.surpbtn);
        surpbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToplaysurpMusic();
            }
        });

        sadbtn = (ImageButton) findViewById(R.id.sadbtn);
        sadbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToplaysadMusic();
            }
        });

        angrybtn = (ImageButton) findViewById(R.id.angrybtn);
        angrybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToplayangryMusic();
            }
        });

        fearbtn = (ImageButton) findViewById(R.id.fearbtn);
        fearbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToplayfearMusic();
            }
        });


    }

    //go to musicActivity
    private void goToplayhappyMusic() {
        Intent intent = new Intent(this, PlayMusicActivity.class);
        intent.putExtra("emotion", "joy");
        startActivity(intent);
    }

    private void goToplaysurpMusic() {
        Intent intent = new Intent(this, PlayMusicActivity.class);
        intent.putExtra("emotion", "surprise");
        startActivity(intent);

    }

    private void goToplaysadMusic() {
        Intent intent = new Intent(this, PlayMusicActivity.class);
        intent.putExtra("emotion", "sad");
        startActivity(intent);
    }

    private void goToplayangryMusic() {
        Intent intent = new Intent(this, PlayMusicActivity.class);
        intent.putExtra("emotion", "angry");
        startActivity(intent);

    }

    private void goToplayfearMusic() {
        Intent intent = new Intent(this, PlayMusicActivity.class);
        intent.putExtra("emotion", "fear");
        startActivity(intent);


    }
}
