package com.villezone.gautam.model;

import java.io.Serializable;

public class Delivery_boy implements Serializable {
    private String name;

    private String mobile_number;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile_number() {
        return mobile_number;
    }

    public void setMobile_number(String mobile_number) {
        this.mobile_number = mobile_number;
    }

    @Override
    public String toString() {
        return "ClassPojo [name = " + name + ", mobile_number = " + mobile_number + "]";
    }
}