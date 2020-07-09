package com.villezone.gautam.model;

import java.util.List;

public class CartResponse {
    private List<CartItem> data;

    public List<CartItem> getData() {
        return data;
    }

    public void setData(List<CartItem> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ClassPojo [data = " + data + "]";
    }
}