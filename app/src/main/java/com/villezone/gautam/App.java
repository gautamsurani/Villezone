package com.villezone.gautam;

import android.app.Application;

import com.villezone.gautam.db.JsonHelper;
import com.villezone.gautam.db.PrefsManager;
import com.google.gson.Gson;

public class App extends Application {
    private static App mApp;
    private static PrefsManager mPrefsManager;

    @Override
    public void onCreate() {
        super.onCreate();
        mApp = this;
        Gson gsonProvider = new Gson();
        JsonHelper jsonHelper = new JsonHelper(gsonProvider);
        mPrefsManager = new PrefsManager(jsonHelper);
    }

    public static App get() {
        return mApp;
    }

    public static PrefsManager getPreference() {
        return mPrefsManager;
    }
}
