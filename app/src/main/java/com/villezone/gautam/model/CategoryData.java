package com.villezone.gautam.model;

import java.util.List;

public class CategoryData {
    private String image;

    private List<Sub_category> sub_category;

    private String id;

    private String title;

    private List<Products> products;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<Sub_category> getSub_category() {
        return sub_category;
    }

    public void setSub_category(List<Sub_category> sub_category) {
        this.sub_category = sub_category;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Products> getProducts() {
        return products;
    }

    public void setProducts(List<Products> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "ClassPojo [image = " + image + ", sub_category = " + sub_category + ", id = " + id + ", title = " + title + ", products = " + products + "]";
    }
}