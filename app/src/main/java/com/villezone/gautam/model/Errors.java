package com.villezone.gautam.model;

public class Errors {
    private String[] old_password;

    public String[] getOld_password() {
        return old_password;
    }

    public void setOld_password(String[] old_password) {
        this.old_password = old_password;
    }

    @Override
    public String toString() {
        return "ClassPojo [old_password = " + old_password + "]";
    }
}