package com.villezone.gautam.model;

public class SearchResult {
    private String title;

    private int id;

    private String type;

    private String image;

    public String getName() {
        return title;
    }

    public void setName(String name) {
        this.title = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "ClassPojo [name = " + title + ", id = " + id + ", type = " + type + "]";
    }
}