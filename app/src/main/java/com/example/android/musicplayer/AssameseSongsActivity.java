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

public class AssameseSongsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.song_list);

        ArrayList<Song> assameseSongs = new ArrayList<Song>();
        assameseSongs.add(new Song("Ahe ba nahe", "By Zubeen Garg"));
        assameseSongs.add(new Song("Monole Ubhati Ahe Lorali", "By Zubeen Garg"));
        assameseSongs.add(new Song("Buku hum hum kore", "By Bhupen Hazarika"));
        assameseSongs.add(new Song("Bistirno Parore", "By Bhupen Hazarika"));
        assameseSongs.add(new Song("Bonoria", "By Angaraag Mahanta (Papon)"));
        assameseSongs.add(new Song("Junake Bisare Ki", "By Angaraag Mahanta (Papon)"));

        SongAdapter adapter = new SongAdapter(this, assameseSongs);
        final ListView listView = (ListView) findViewById(R.id.list);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Song currentSong = (Song) listView.getItemAtPosition(position);
                Intent currentSongIntent = new Intent(AssameseSongsActivity.this, NowPlayingActivity.class);
                currentSongIntent.putExtra(String.valueOf(R.string.now_playing_song_title), currentSong.getSongTitle());
                currentSongIntent.putExtra(String.valueOf(R.string.now_playing_artist_name), currentSong.getArtistName());
                startActivity(currentSongIntent);
            }
        });

        listView.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.assamese_songs_menu, menu);
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
