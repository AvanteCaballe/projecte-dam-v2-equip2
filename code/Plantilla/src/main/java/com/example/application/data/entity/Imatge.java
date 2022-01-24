package com.example.application.data.entity;

import com.example.application.data.AbstractEntity;
import com.vaadin.flow.component.html.Image;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
public class Imatge extends AbstractEntity{

    @NotEmpty
    private int id;

    @NotEmpty
    private String title = "";

    @NotEmpty
    private String author = "";

    @NotEmpty
    private String theme = "";

    private Image src;

    public Imatge(int id, String title, String author, String theme, Image src) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.theme = theme;
        this.src = src;
    }

    public Imatge() {

    }

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Image getSrc() {
        return src;
    }

    public void setSrc(Image src) {
        this.src = src;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }
}


