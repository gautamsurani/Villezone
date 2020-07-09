package com.villezone.gautam.model;

import java.io.Serializable;

public class Order implements Serializable {
    private String order_date;

    private String order_status;

    private String feedback;

    private String image;

    private String order_key;

    private String delivery_charge;

    private String payment_status;

    private String expected_delivery_date;

    private String id;

    private Delivery_boy delivery_boy;

    private String total_with_delivery_charge;

    private String payment_method;

    private String total_order_price;

    public String getOrder_date() {
        return order_date;
    }

    public void setOrder_date(String order_date) {
        this.order_date = order_date;
    }

    public String getOrder_status() {
        return order_status;
    }

    public void setOrder_status(String order_status) {
        this.order_status = order_status;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getOrder_key() {
        return order_key;
    }

    public void setOrder_key(String order_key) {
        this.order_key = order_key;
    }

    public String getDelivery_charge() {
        return delivery_charge;
    }

    public void setDelivery_charge(String delivery_charge) {
        this.delivery_charge = delivery_charge;
    }

    public String getPayment_status() {
        return payment_status;
    }

    public void setPayment_status(String payment_status) {
        this.payment_status = payment_status;
    }

    public String getExpected_delivery_date() {
        return expected_delivery_date;
    }

    public void setExpected_delivery_date(String expected_delivery_date) {
        this.expected_delivery_date = expected_delivery_date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Delivery_boy getDelivery_boy() {
        return delivery_boy;
    }

    public void setDelivery_boy(Delivery_boy delivery_boy) {
        this.delivery_boy = delivery_boy;
    }

    public String getTotal_with_delivery_charge() {
        return total_with_delivery_charge;
    }

    public void setTotal_with_delivery_charge(String total_with_delivery_charge) {
        this.total_with_delivery_charge = total_with_delivery_charge;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public String getPayment_method() {
        return payment_method;
    }

    public void setPayment_method(String payment_method) {
        this.payment_method = payment_method;
    }

    public String getTotal_order_price() {
        return total_order_price;
    }

    public void setTotal_order_price(String total_order_price) {
        this.total_order_price = total_order_price;
    }

    @Override
    public String toString() {
        return "ClassPojo [order_date = " + order_date + ", order_status = " + order_status + ", image = " + image + ", order_key = " + order_key + ", delivery_charge = " + delivery_charge + ", payment_status = " + payment_status + ", expected_delivery_date = " + expected_delivery_date + ", id = " + id + ", delivery_boy = " + delivery_boy + ", total_with_delivery_charge = " + total_with_delivery_charge + ", payment_method = " + payment_method + ", total_order_price = " + total_order_price + "]";
    }
}