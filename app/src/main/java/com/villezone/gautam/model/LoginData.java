package com.villezone.gautam.model;

public class LoginData {
    private String access_token;

    private User_detail user_detail;

    private String message;

    private String token_type;

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public User_detail getUser_detail() {
        return user_detail;
    }

    public void setUser_detail(User_detail user_detail) {
        this.user_detail = user_detail;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getToken_type() {
        return token_type;
    }

    public void setToken_type(String token_type) {
        this.token_type = token_type;
    }

    @Override
    public String toString() {
        return "ClassPojo [access_token = " + access_token + ", user_detail = " + user_detail + ", message = " + message + ", token_type = " + token_type + "]";
    }
}