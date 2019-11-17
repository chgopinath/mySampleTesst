package com.drivetests.androidtask2.model;

import java.io.Serializable;
import java.util.ArrayList;

public class TitleObject implements Serializable {
    private String value;
    private String matchLevel;
    ArrayList<Object> matchedWords = new ArrayList < Object > ();


    // Getter Methods

    public String getValue() {
        return value;
    }

    public ArrayList<Object> getMatchedWords() {
        return matchedWords;
    }

    public void setMatchedWords(ArrayList<Object> matchedWords) {
        this.matchedWords = matchedWords;
    }

    public String getMatchLevel() {
        return matchLevel;
    }

    // Setter Methods

    public void setValue(String value) {
        this.value = value;
    }

    public void setMatchLevel(String matchLevel) {
        this.matchLevel = matchLevel;
    }
}
