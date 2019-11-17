package com.drivetests.androidtask2.model;

import java.io.Serializable;

public class HighlightResult implements Serializable {

    TitleObject title;
    UrlModel url;
    AuthorModel author;


    // Getter Methods

    public TitleObject getTitle() {
        return title;
    }

    public UrlModel getUrl() {
        return url;
    }

    public AuthorModel getAuthor() {
        return author;
    }

    // Setter Methods

    public void setTitle(TitleObject title) {
        this.title = title;
    }

    public void setUrl(UrlModel url) {
        this.url = url;
    }

    public void setAuthor(AuthorModel author) {
        this.author = author;
    }
}
