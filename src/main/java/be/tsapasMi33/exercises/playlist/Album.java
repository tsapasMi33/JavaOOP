package be.tsapasMi33.exercises.playlist;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    public static class SongList {
        private ArrayList<Song> songs;

        private SongList() {
            this.songs = new ArrayList<Song>();
        }

        private boolean add(Song song) {
            if (songs.contains(song)){
                return false;
            }
            this.songs.add(song);
            return true;
        }

        private Song findSong(String title) {
            for (Song song : this.songs) {
                if (song.getTitle().equals(title)) {
                    return song;
                }
            }
            return null;
        }

        private Song findSong(int trackNo) {
            if (trackNo > 0 && trackNo <= songs.size()) {
                return songs.get(trackNo - 1);
            }
            return null;
        }
    }
    private String name;
    private String artist;
    private SongList songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new SongList();
    }

    public boolean addSong(String title, double duration) {
            return songs.add(new Song(title, duration));
    }

    public boolean addToPlayList(int trackNo, LinkedList<Song> playlist) {
        Song foundSong = this.songs.findSong(trackNo);
        if (foundSong != null) {
            playlist.add(foundSong);
            return true;
        }
        return false;
    }

    public boolean addToPlayList(String title, LinkedList<Song> playlist) {
        Song foundSong = this.songs.findSong(title);
        if (foundSong != null) {
            playlist.add(foundSong);
            return true;
        }
        return false;
    }
}
