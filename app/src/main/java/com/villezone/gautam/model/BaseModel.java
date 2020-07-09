package com.villezone.gautam.model;

public class BaseModel {
    private BaseData data;

    public BaseData getData() {
        return data;
    }

    public void setData(BaseData data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ClassPojo [data = " + data + "]";
    }
}
