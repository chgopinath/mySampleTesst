package com.drivetests.androidtask2.model;
import java.io.Serializable;
import java.util.ArrayList;

public class ListModel implements Serializable {

    ArrayList<ObjectModel> hits = new ArrayList < ObjectModel > ();
    private float nbHits;
    private float page;
    private float nbPages;
    private float hitsPerPage;
    private boolean exhaustiveNbHits;
    private String query;
    private String params;
    private float processingTimeMS;


    public ArrayList<ObjectModel> getHits() {
        return hits;
    }

    public void setHits(ArrayList<ObjectModel> hits) {
        this.hits = hits;
    }


    // Getter Methods

    public float getNbHits() {
        return nbHits;
    }

    public float getPage() {
        return page;
    }

    public float getNbPages() {
        return nbPages;
    }

    public float getHitsPerPage() {
        return hitsPerPage;
    }

    public boolean getExhaustiveNbHits() {
        return exhaustiveNbHits;
    }

    public String getQuery() {
        return query;
    }

    public String getParams() {
        return params;
    }

    public float getProcessingTimeMS() {
        return processingTimeMS;
    }

    // Setter Methods

    public void setNbHits(float nbHits) {
        this.nbHits = nbHits;
    }

    public void setPage(float page) {
        this.page = page;
    }

    public void setNbPages(float nbPages) {
        this.nbPages = nbPages;
    }

    public void setHitsPerPage(float hitsPerPage) {
        this.hitsPerPage = hitsPerPage;
    }

    public void setExhaustiveNbHits(boolean exhaustiveNbHits) {
        this.exhaustiveNbHits = exhaustiveNbHits;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public void setProcessingTimeMS(float processingTimeMS) {
        this.processingTimeMS = processingTimeMS;
    }
}