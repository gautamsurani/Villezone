package com.villezone.gautam.model;

public class OrderDetail {
    private Products product;

    private String quantity;

    private String price;

    private String weight;

    private String id;

    private String product_name;

    public Products getProduct() {
        return product;
    }

    public void setProduct(Products product) {
        this.product = product;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    @Override
    public String toString() {
        return "ClassPojo [product = " + product + ", quantity = " + quantity + ", price = " + price + ", weight = " + weight + ", id = " + id + ", product_name = " + product_name + "]";
    }
}