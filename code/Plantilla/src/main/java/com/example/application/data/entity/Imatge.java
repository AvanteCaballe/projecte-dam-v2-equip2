package com.example.application.data.entity;

import com.example.application.data.AbstractEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.vaadin.flow.component.html.Image;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Imatge extends AbstractEntity{

    @NotEmpty
    private String title = "";

    @NotEmpty
    private String author = "";

    @NotEmpty
    private String theme = "";

    private Image src;

    public Imatge(String title, String author, String theme, Image src) {
        this.title = title;
        this.author = author;
        this.theme = theme;
        this.src = src;
    }

    public Imatge() {

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


