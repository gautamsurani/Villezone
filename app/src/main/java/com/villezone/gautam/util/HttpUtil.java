package com.villezone.gautam.util;

import android.widget.Toast;

import com.villezone.gautam.App;
import com.villezone.gautam.model.ErrorResponse;
import com.villezone.gautam.model.Response422;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.IOException;

import retrofit2.Response;

public class HttpUtil {
    public static void handleError(Response response) {
        JsonParser parser = new JsonParser();
        JsonElement mJson = null;
        try {
            if (response.code() == 422) {
                mJson = parser.parse(response.errorBody().string());
                Gson gson = new Gson();
                Response422 errorResponse = gson.fromJson(mJson, Response422.class);
                Toast.makeText(App.get(), errorResponse.getMessage(), Toast.LENGTH_SHORT).show();
            } else {
                mJson = parser.parse(response.errorBody().string());
                Gson gson = new Gson();
                ErrorResponse errorResponse = gson.fromJson(mJson, ErrorResponse.class);
                Toast.makeText(App.get(), errorResponse.getError().getMessage(), Toast.LENGTH_SHORT).show();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
