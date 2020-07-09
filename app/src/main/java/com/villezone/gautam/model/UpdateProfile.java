package com.villezone.gautam.model;

public class UpdateProfile {
    String message;
    User_detail customer;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public User_detail getCustomer() {
        return customer;
    }

    public void setCustomer(User_detail customer) {
        this.customer = customer;
    }
}
