package com.example.kleimaj.jamr_v2;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by kleimaj on 10/20/18.
 */

public class ArtistModel {
    private String name;
    private String bio;
    private String gender;
    private int age;
    private boolean isBand;
    private ArrayList<String> identities; //e.g. Producer, Guitarist, Vocalist
    private ArrayList<String> genres; //can switch to a String[] if need be

    /*Constructors*/

    public ArtistModel(String name){ //for testing
        this.name = name;
        age = -1;
        genres = new ArrayList<String>();
        identities = new ArrayList<String>();
    }

    public ArtistModel(String name, String gender) { //for testing
        this.name = name;
        this.gender = gender;
        age = -1;
        genres = new ArrayList<String>();
        identities = new ArrayList<String>();
    }

    public ArtistModel(String name, String gender, int age){ //for actual use
        this.name = name;
        this.gender = gender;
        this.age = age;
        genres = new ArrayList<String>();
        identities = new ArrayList<String>();
    }

    /*Setters*/

    public void setBio(String bio){
        this.bio = bio;
    }

    public void setBand(boolean bool) { isBand = bool;}

    public void setGender(String gender){
        this.gender = gender;
    }

    public void setGenres(ArrayList<String> genres){
        this.genres = new ArrayList<String>(genres);
    }

    public void setIdentities(ArrayList<String> identities){
        this.identities = identities;
    }

    /*Getters*/

    public String getName() {
        return name;
    }

    public String getBio() {
        return bio;
    }

    public String getGender(){
        return gender;
    }

    public boolean isBand() {return isBand; }

    public int getAge(){
        return age;
    }

    public ArrayList<String> getIdentities() {
        return identities;
    }

    public ArrayList<String> getGenres() {
        return genres;
    }
}
