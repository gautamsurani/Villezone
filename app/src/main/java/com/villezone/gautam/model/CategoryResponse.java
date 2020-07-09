package com.villezone.gautam.model;

import java.util.List;

public class CategoryResponse {
    private List<CategoryData> data;

    public List<CategoryData>getData() {
        return data;
    }

    public void setData(List<CategoryData> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ClassPojo [data = " + data + "]";
    }
}
