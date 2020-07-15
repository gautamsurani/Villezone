package com.villezone.gautam.model;

public class Notification {
    private String created_at;

    private String id;

    private String message;

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ClassPojo [created_at = " + created_at + ", id = " + id + ", message = " + message + "]";
    }
}