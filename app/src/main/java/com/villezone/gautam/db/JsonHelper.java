package com.villezone.gautam.db;

import com.google.gson.Gson;

public class JsonHelper {

    private final Gson mGson;

    public JsonHelper(Gson gson) {
        mGson = gson;
    }

    public <T> T fromJson(String json, Class<T> classOfT) {
        if (json == null) return null;
        try {
            return mGson.fromJson(json, classOfT);
        } catch (Throwable t) {

        }
        return null;
    }

    public String toJson(Object object) {
        return mGson.toJson(object);
    }
}