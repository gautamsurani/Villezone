package com.villezone.gautam.model;

import java.io.Serializable;

public class TimeSlotList implements Serializable {
    private TimeSlot first;
    private TimeSlot second;
    private TimeSlot third;

    public TimeSlot getFirst() {
        return first;
    }

    public void setFirst(TimeSlot first) {
        this.first = first;
    }

    public TimeSlot getSecond() {
        return second;
    }

    public void setSecond(TimeSlot second) {
        this.second = second;
    }

    public TimeSlot getThird() {
        return third;
    }

    public void setThird(TimeSlot third) {
        this.third = third;
    }
}
