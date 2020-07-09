package com.villezone.gautam.model;

public class User_detail {
    private Area area;

    private String account_created_at;

    private String address;

    private String pin_code;

    private String name;

    private String id;

    private String mobile_number;

    private String email;

    private int total_cart_products;

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public String getAccount_created_at() {
        return account_created_at;
    }

    public void setAccount_created_at(String account_created_at) {
        this.account_created_at = account_created_at;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPin_code() {
        return pin_code;
    }

    public void setPin_code(String pin_code) {
        this.pin_code = pin_code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMobile_number() {
        return mobile_number;
    }

    public void setMobile_number(String mobile_number) {
        this.mobile_number = mobile_number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTotal_cart_products() {
        return total_cart_products;
    }

    public void setTotal_cart_products(int total_cart_products) {
        this.total_cart_products = total_cart_products;
    }

    @Override
    public String toString() {
        return "ClassPojo [area = " + area + ", account_created_at = " + account_created_at + ", address = " + address + ", pin_code = " + pin_code + ", name = " + name + ", id = " + id + ", mobile_number = " + mobile_number + ", email = " + email + "]";
    }
}