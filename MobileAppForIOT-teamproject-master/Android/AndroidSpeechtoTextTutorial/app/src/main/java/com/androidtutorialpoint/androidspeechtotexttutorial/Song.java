package com.androidtutorialpoint.androidspeechtotexttutorial;

/**
 * Created by Qian on 5/1/17.
 */

public class Song {
    private String filename;
    private String songTitle;
    private String singer;

    public String getSongTitle() {
        return songTitle;
    }

    public void setSongTitle(String songTitle) {
        this.songTitle = songTitle;
    }

    public Song(String filename, String title, String singer) {
        this.filename = filename;
        this.singer = singer;
        this.songTitle = title;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    @Override
    public String toString() {
        return "Song{" +
                "filename='" + filename + '\'' +
                ", songTitle='" + songTitle + '\'' +
                ", singer='" + singer + '\'' +
                '}';
    }
}
