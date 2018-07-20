package com.example.android.musicplayer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class NowPlayingActivity extends AppCompatActivity {
    private boolean isPlay = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_now_playing);

        TextView songTitle = (TextView) findViewById(R.id.now_playing_song_title);
        TextView artistName = (TextView) findViewById(R.id.now_playing_artist_name);

        Intent intent = getIntent();

        songTitle.setText(intent.getStringExtra(String.valueOf(R.string.now_playing_song_title)));
        artistName.setText(intent.getStringExtra(String.valueOf(R.string.now_playing_artist_name)));

        final Button playButton = (Button) findViewById(R.id.now_play_pause_button);
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isPlay) {
                    playButton.setBackgroundResource(R.drawable.sharp_pause_black_48);
                    isPlay = false;
                } else {
                    playButton.setBackgroundResource(R.drawable.sharp_play_arrow_black_48);
                    isPlay = true;
                }

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.now_playing_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.home_menu:
                startActivity(new Intent(this, MainActivity.class));
                break;

            case R.id.assamese_songs_menu:
                startActivity(new Intent(this, AssameseSongsActivity.class));
                break;

            case R.id.hindi_songs_menu:
                startActivity(new Intent(this, HindiSongsActivity.class));
                break;

            case R.id.english_songs_menu:
                startActivity(new Intent(this, EnglishSongsActivity.class));
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
