package com.example.android.musicplayer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Assamese Song
        LinearLayout assameseSongLayout = (LinearLayout) findViewById(R.id.assamese_category);
        assameseSongLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent assameseSongsIntent = new Intent(MainActivity.this, AssameseSongsActivity.class);
                startActivity(assameseSongsIntent);
            }
        });


        //Hindi Songs
        LinearLayout hindiSongLayout = (LinearLayout) findViewById(R.id.hindi_category);
        hindiSongLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent hindiSongsIntent = new Intent(MainActivity.this, HindiSongsActivity.class);
                startActivity(hindiSongsIntent);
            }
        });


        //English songs
        LinearLayout englishSongLayout = (LinearLayout) findViewById(R.id.english_category);
        englishSongLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent englishSongsIntent = new Intent(MainActivity.this, EnglishSongsActivity.class);
                startActivity(englishSongsIntent);
            }
        });
    }
}
