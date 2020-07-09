package com.villezone.gautam.model;

public class UpdateProfileResponse {
    private UpdateProfile data;

    public UpdateProfile getData() {
        return data;
    }

    public void setData(UpdateProfile data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ClassPojo [data = " + data + "]";
    }
}
