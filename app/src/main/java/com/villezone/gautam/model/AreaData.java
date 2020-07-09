package com.villezone.gautam.model;

import java.io.Serializable;

public class AreaData implements Serializable {
    private String[] pincode;

    private String name;

    private String id;

    private TimeSlotList time_slot;

    private String minimum_order;
    private String delivery_charge;
    private String expected_delivery_date;

    public String[] getPincode() {
        return pincode;
    }

    public void setPincode(String[] pincode) {
        this.pincode = pincode;
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

    public String getMinimum_order() {
        return minimum_order;
    }

    public void setMinimum_order(String minimum_order) {
        this.minimum_order = minimum_order;
    }

    public String getDelivery_charge() {
        return delivery_charge;
    }

    public void setDelivery_charge(String delivery_charge) {
        this.delivery_charge = delivery_charge;
    }

    public String getExpected_delivery_date() {
        return expected_delivery_date;
    }

    public void setExpected_delivery_date(String expected_delivery_date) {
        this.expected_delivery_date = expected_delivery_date;
    }

    public TimeSlotList getTime_slot() {
        return time_slot;
    }

    public void setTime_slot(TimeSlotList time_slot) {
        this.time_slot = time_slot;
    }

    @Override
    public String toString() {
        return "ClassPojo [pincode = " + pincode + ", name = " + name + ", id = " + id + "]";
    }
}