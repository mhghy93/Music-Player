package com.example.android.musicplayer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class EnglishSongsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.song_list);

        final ArrayList<Song> englishSongs = new ArrayList<Song>();
        englishSongs.add(new Song("In the End", "By Linkin Park"));
        englishSongs.add(new Song("Numb", "By Linkin Park"));
        englishSongs.add(new Song("Hallowed Be Thy Name", "By Iron Maiden"));
        englishSongs.add(new Song("Trooper", "By Iron Maiden"));
        englishSongs.add(new Song("No Pain No Gain", "By Scorpions"));
        englishSongs.add(new Song("Dance Of Death", "By Iron Maiden"));

        SongAdapter adapter = new SongAdapter(this, englishSongs);
        final ListView listView = (ListView) findViewById(R.id.list);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Song currentSong = (Song) listView.getItemAtPosition(position);
                Intent currentSongIntent = new Intent(EnglishSongsActivity.this, NowPlayingActivity.class);
                currentSongIntent.putExtra(String.valueOf(R.string.now_playing_song_title), currentSong.getSongTitle());
                currentSongIntent.putExtra(String.valueOf(R.string.now_playing_artist_name), currentSong.getArtistName());
                startActivity(currentSongIntent);
            }
        });

        listView.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.english_songs_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.home_menu:
                startActivity(new Intent(this, MainActivity.class));
                break;

            case R.id.now_playing_menu:
                startActivity(new Intent(this, NowPlayingActivity.class));
                break;

            case R.id.assamese_songs_menu:
                startActivity(new Intent(this, AssameseSongsActivity.class));
                break;

            case R.id.hindi_songs_menu:
                startActivity(new Intent(this, HindiSongsActivity.class));
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
