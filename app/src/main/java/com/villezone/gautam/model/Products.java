package com.villezone.gautam.model;

import java.io.Serializable;
import java.util.List;

public class Products implements Serializable {
    private List<String> images;

    private String gujarati_name;

    private String description;

    private String discount;

    private String hindi_name;

    private String hindi_description;

    private String discounted_price;

    private String gujarati_description;

    private String category_id;

    private String sub_category_id;

    private String price;

    private String name;

    private String id;

    private String sell_type;

    private List<Price> sell_type_options;

    private String stock;

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public String getGujarati_name() {
        return gujarati_name;
    }

    public void setGujarati_name(String gujarati_name) {
        this.gujarati_name = gujarati_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getHindi_name() {
        return hindi_name;
    }

    public void setHindi_name(String hindi_name) {
        this.hindi_name = hindi_name;
    }

    public String getHindi_description() {
        return hindi_description;
    }

    public void setHindi_description(String hindi_description) {
        this.hindi_description = hindi_description;
    }

    public String getDiscounted_price() {
        return discounted_price;
    }

    public void setDiscounted_price(String discounted_price) {
        this.discounted_price = discounted_price;
    }

    public String getGujarati_description() {
        return gujarati_description;
    }

    public void setGujarati_description(String gujarati_description) {
        this.gujarati_description = gujarati_description;
    }

    public String getCategory_id() {
        return category_id;
    }

    public void setCategory_id(String category_id) {
        this.category_id = category_id;
    }

    public String getSub_category_id() {
        return sub_category_id;
    }

    public void setSub_category_id(String sub_category_id) {
        this.sub_category_id = sub_category_id;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSell_type() {
        return sell_type;
    }

    public void setSell_type(String sell_type) {
        this.sell_type = sell_type;
    }

    public List<Price> getSell_type_options() {
        return sell_type_options;
    }

    public void setSell_type_options(List<Price> sell_type_options) {
        this.sell_type_options = sell_type_options;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "ClassPojo [images = " + images + ", gujarati_name = " + gujarati_name + ", description = " + description + ", discount = " + discount + ", hindi_name = " + hindi_name + ", hindi_description = " + hindi_description + ", discounted_price = " + discounted_price + ", gujarati_description = " + gujarati_description + ", category_id = " + category_id + ", sub_category_id = " + sub_category_id + ", price = " + price + ", name = " + name + ", id = " + id + "]";
    }
}