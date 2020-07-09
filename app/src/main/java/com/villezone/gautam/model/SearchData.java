package com.villezone.gautam.model;

import java.util.List;

public class SearchData {
    private List<SearchResult> result;

    private String message;

    public List<SearchResult> getResult() {
        return result;
    }

    public void setResult(List<SearchResult> result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ClassPojo [result = " + result + ", message = " + message + "]";
    }
}