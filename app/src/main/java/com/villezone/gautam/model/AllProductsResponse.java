package com.villezone.gautam.model;

import java.util.List;

public class AllProductsResponse {
    private List<Products> data;

    private PageMeta meta;

    public List<Products> getData() {
        return data;
    }

    public PageMeta getMeta() {
        return meta;
    }

    public void setMeta(PageMeta meta) {
        this.meta = meta;
    }

    public void setData(List<Products> data) {
        this.data = data;
    }
}
