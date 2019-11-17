package com.drivetests.androidtask2.model;

import java.io.Serializable;
import java.util.ArrayList;

public class ObjectModel implements Serializable {

    private String created_at;
    private String title;
    private String url;
    private String author;
    private float points;
    private String story_text = null;
    private String comment_text = null;
    private float num_comments;
    private String story_id = null;
    private String story_title = null;
    private String story_url = null;
    private String parent_id = null;
    private float created_at_i;
    ArrayList <String> _tags = new ArrayList <String> ();
    private String objectID;
    HighlightResult _highlightResultObject;


    // Getter Methods

    public String getCreated_at() {
        return created_at;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    public String getAuthor() {
        return author;
    }

    public float getPoints() {
        return points;
    }

    public String getStory_text() {
        return story_text;
    }

    public String getComment_text() {
        return comment_text;
    }

    public float getNum_comments() {
        return num_comments;
    }

    public String getStory_id() {
        return story_id;
    }

    public String getStory_title() {
        return story_title;
    }

    public String getStory_url() {
        return story_url;
    }

    public String getParent_id() {
        return parent_id;
    }

    public float getCreated_at_i() {
        return created_at_i;
    }

    public String getObjectID() {
        return objectID;
    }

    public HighlightResult get_highlightResult() {
        return _highlightResultObject;
    }

    // Setter Methods

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPoints(float points) {
        this.points = points;
    }

    public void setStory_text(String story_text) {
        this.story_text = story_text;
    }

    public void setComment_text(String comment_text) {
        this.comment_text = comment_text;
    }

    public void setNum_comments(float num_comments) {
        this.num_comments = num_comments;
    }

    public void setStory_id(String story_id) {
        this.story_id = story_id;
    }

    public void setStory_title(String story_title) {
        this.story_title = story_title;
    }

    public void setStory_url(String story_url) {
        this.story_url = story_url;
    }

    public void setParent_id(String parent_id) {
        this.parent_id = parent_id;
    }

    public void setCreated_at_i(float created_at_i) {
        this.created_at_i = created_at_i;
    }

    public void setObjectID(String objectID) {
        this.objectID = objectID;
    }

    public void set_highlightResult(HighlightResult _highlightResultObject) {
        this._highlightResultObject = _highlightResultObject;
    }
}





