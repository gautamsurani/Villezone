package com.villezone.gautam.model;

import java.io.Serializable;

public class Price implements Serializable {
    String weight;
    int price;

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
