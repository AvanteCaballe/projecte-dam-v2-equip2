package com.example.application.data.entity;

import com.example.application.data.AbstractEntity;

import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;

@Entity
public class Historia extends AbstractEntity {

    @NotEmpty
    private int storyID;

    @NotEmpty
    private int imageID;

    @NotEmpty
    private int userID;

    @NotEmpty
    private String title;

    @NotEmpty
    private String contents;

    @NotEmpty
    private int score;

    @NotEmpty
    private Categories category;

    public Historia() {
    }

    public Historia(int storyID, int imageID, int userID, String title, String contents, Categories category) {
        this.storyID = storyID;
        this.imageID = imageID;
        this.userID = userID;
        this.title = title;
        this.contents = contents;
        this.category = category;
    }

    public int getStoryID() {
        return storyID;
    }

    public void setStoryID(int storyID) {
        this.storyID = storyID;
    }

    public int getImageID() {
        return imageID;
    }

    public void setImageID(int imageID) {
        this.imageID = imageID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Categories getCategory() {
        return category;
    }

    public void setCategory(Categories category) {
        this.category = category;
    }
}
