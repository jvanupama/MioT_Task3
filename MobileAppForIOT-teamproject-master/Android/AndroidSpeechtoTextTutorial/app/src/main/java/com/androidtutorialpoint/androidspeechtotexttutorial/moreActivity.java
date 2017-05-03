package com.androidtutorialpoint.androidspeechtotexttutorial;

import android.content.Context;
import android.content.Intent;
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

public class moreActivity extends AppCompatActivity {
    private ImageButton emoji;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more);

        emoji = (ImageButton) findViewById(R.id.emoji);
        emoji.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goTohomeActivity();
            }
        });
    }

        //go to homeActivity
    private void goTohomeActivity() {
        Intent intent = new Intent(this, homeActivity.class);
        startActivity(intent);
    }
}
