package com.villezone.gautam.model;

import java.util.List;

public class AreaResponse {
    private List<AreaData> data;

    public List<AreaData> getData() {
        return data;
    }

    public void setData(List<AreaData> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ClassPojo [data = " + data + "]";
    }
}
