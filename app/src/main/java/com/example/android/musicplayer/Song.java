package com.example.android.musicplayer;

public class Song {

    private String mSongTitle;
    private String mArtistName;

    public Song(String songTitle, String artistName) {
        mSongTitle = songTitle;
        mArtistName = artistName;
    }

    public String getSongTitle() {
        return mSongTitle;
    }

    public String getArtistName() {
        return mArtistName;
    }
}
