package com.villezone.gautam.model;

public class ErrorResponse {
    private Error error;

    public Error getError() {
        return error;
    }

    public void setError(Error error) {
        this.error = error;
    }

    @Override
    public String toString() {
        return "ClassPojo [error = " + error + "]";
    }
}