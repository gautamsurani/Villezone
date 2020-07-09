package com.villezone.gautam.model;

import java.util.List;

public class AllProductsResponse {
    List<Products> data;

    public List<Products> getData() {
        return data;
    }

    public void setData(List<Products> data) {
        this.data = data;
    }
}
