package com.villezone.gautam.model;

public class Response422 {
    private String message;

    private Errors errors;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Errors getErrors() {
        return errors;
    }

    public void setErrors(Errors errors) {
        this.errors = errors;
    }

    @Override
    public String toString() {
        return "ClassPojo [message = " + message + ", errors = " + errors + "]";
    }
}