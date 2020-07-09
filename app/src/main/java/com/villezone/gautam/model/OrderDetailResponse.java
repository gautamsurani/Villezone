package com.villezone.gautam.model;

import java.util.List;

public class OrderDetailResponse {
    private List<OrderDetail> data;

    public List<OrderDetail> getData() {
        return data;
    }

    public void setData(List<OrderDetail> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ClassPojo [data = " + data + "]";
    }
}