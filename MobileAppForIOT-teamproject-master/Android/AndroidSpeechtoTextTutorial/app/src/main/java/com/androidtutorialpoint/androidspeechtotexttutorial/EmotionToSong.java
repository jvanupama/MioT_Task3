package com.androidtutorialpoint.androidspeechtotexttutorial;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by Qian on 5/1/17.
 */

public class EmotionToSong {
    private ArrayList<Song> joyMap;
    private ArrayList<Song> sadnessMap;
    private ArrayList<Song> angryMap;
    private ArrayList<Song> fearMap;
    private ArrayList<Song> supriseMap;
    private Map<String, ArrayList> songMap;

    public EmotionToSong() {
        songMap = new HashMap<>();
        joyMap = new ArrayList<>();
        sadnessMap = new ArrayList<>();
        angryMap = new ArrayList<>();
        fearMap = new ArrayList<>();
        supriseMap = new ArrayList<>();

        //=====init with songs
        //1
        joyMap.add(new Song("happy","Happy", "Pharrell Williams"));
        joyMap.add(new Song("moves_like_jagger","Moves like Jagger", "Maroon 5"));

        //2
        sadnessMap.add(new Song("someone_like_you", "Someone Like You", "Adele"));
        sadnessMap.add(new Song("stay_with_me", "Stay with me", "Sam Smith"));

        //3
        angryMap.add(new Song("break_stuff","Break Stuff", "Limp Bizkit "));
        angryMap.add(new Song("down_with_the_sickness","Down With The Sickness", "Disturbed"));

        //4
        fearMap.add(new Song("you_raise_me_up","You raise me up", "Westlife"));
        fearMap.add(new Song("when_you_believe","When You Believe", "Whitney Houston"));

        //5
        supriseMap.add(new Song("gangnan_style","Gangnam Style", "PSY"));

        // add back to big map

        songMap.put("joy", joyMap);
        songMap.put("sadness", sadnessMap);
        songMap.put("fear", fearMap);
        songMap.put("anger", angryMap);
        songMap.put("surprise", supriseMap);

    }

    public Map<String, ArrayList> getSongMap() {
        return songMap;
    }

    public void setSongMap(Map<String, ArrayList> songMap) {
        this.songMap = songMap;
    }

    public ArrayList<Song> getSupriseMap() {
        return supriseMap;
    }

    public void setSupriseMap(ArrayList<Song> supriseMap) {
        this.supriseMap = supriseMap;
    }

    public ArrayList<Song> getFearMap() {
        return fearMap;
    }

    public void setFearMap(ArrayList<Song> fearMap) {
        this.fearMap = fearMap;
    }

    public ArrayList<Song> getAngryMap() {
        return angryMap;
    }

    public void setAngryMap(ArrayList<Song> angryMap) {
        this.angryMap = angryMap;
    }

    public ArrayList<Song> getSadnessMap() {
        return sadnessMap;
    }

    public void setSadnessMap(ArrayList<Song> sadnessMap) {
        this.sadnessMap = sadnessMap;
    }

    public ArrayList<Song> getJoyMap() {
        return joyMap;
    }

    public void setJoyMap(ArrayList<Song> joyMap) {
        this.joyMap = joyMap;
    }

    public Song getSong(String emotion) {
        if (!songMap.containsKey(emotion)) {
            return null;
        }

        ArrayList<Song> emotionSongList = songMap.get(emotion);
        int index = randInt(0, emotionSongList.size());
        return emotionSongList.get(index);
    }

    public static int randInt(int min, int max) {

        // NOTE: This will (intentionally) not run as written so that folks
        // copy-pasting have to think about how to initialize their
        // Random instance.  Initialization of the Random instance is outside
        // the main scope of the question, but some decent options are to have
        // a field that is initialized once and then re-used as needed or to
        // use ThreadLocalRandom (if using at least Java 1.7).
        Random rand = new Random();

        // nextInt is normally exclusive of the top value,
        // so add 1 to make it inclusive
        int randomNum = rand.nextInt((max - min)) + min;

        return randomNum;
    }
}
