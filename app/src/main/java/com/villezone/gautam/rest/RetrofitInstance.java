package com.villezone.gautam.rest;

import androidx.annotation.NonNull;

import com.villezone.gautam.App;
import com.villezone.gautam.db.PrefsManager;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {

    private static String BASE_URL_WITH_STAGING_200 = "http://www.villezone.com/api/";
    private static Retrofit retrofit = null;

    private static final String mServerUrl = BASE_URL_WITH_STAGING_200;
    static PrefsManager prefsManager = App.getPreference();

    public static Retrofit getClient() {
        if (retrofit == null) {
            OkHttpClient.Builder httpClient = UnsafeOkHttpClient.getUnsafeOkHttpClient();
            httpClient.callTimeout(60, TimeUnit.SECONDS);
            httpClient.connectTimeout(60, TimeUnit.SECONDS);
            httpClient.readTimeout(60, TimeUnit.SECONDS);
            httpClient.writeTimeout(60, TimeUnit.SECONDS);
            httpClient.addInterceptor(new Interceptor() {
                @NotNull
                @Override
                public Response intercept(@NonNull Chain chain) throws IOException {
                    String apiToken = prefsManager.getAuthToken();
                    Request request = chain.request()
                            .newBuilder()
                            .addHeader(ApiURLs.API_TOKEN, "Bearer " + apiToken)
                            .header("Accept", "application/json")
                            .build();
                    return chain.proceed(request);
                }
            });
            httpClient.addNetworkInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY));
            Gson gson = new GsonBuilder().setLenient().create();
            retrofit = new Retrofit.Builder()
                    .baseUrl(mServerUrl)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .client(httpClient.build())
                    .build();
        }
        return retrofit;
    }
}