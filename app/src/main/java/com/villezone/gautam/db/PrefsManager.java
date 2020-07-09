package com.villezone.gautam.db;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.villezone.gautam.App;
import com.villezone.gautam.model.User_detail;

import java.util.HashMap;
import java.util.Map;

public class PrefsManager {

    //region Members
    private final SharedPreferences mSharedPrefs;
    private final SharedPreferences.Editor mSharedPrefsEditor;

    private Map<String, String> mChatUnreadChannel;
    private Map<String, String> mPath;
    private Map<String, String> mFileName;
    private JsonHelper mJsonHelper;

    private String mToken;

    User_detail mUserAccount;

    @SuppressLint("CommitPrefEdits")
    public PrefsManager(JsonHelper jsonHelper) {
        mJsonHelper = jsonHelper;
        mSharedPrefs = PreferenceManager.getDefaultSharedPreferences(App.get());
        mSharedPrefsEditor = mSharedPrefs.edit();
    }

    public void setDownloadLink(Map<String, String> mChatUnreadChannel) {
        this.mChatUnreadChannel = mChatUnreadChannel;
        String json = mJsonHelper.toJson(mChatUnreadChannel);

        mSharedPrefsEditor.putString("urls", json);
        mSharedPrefsEditor.commit();
    }

    public Map<String, String> getDownloadLink() {
        if (mChatUnreadChannel == null) {
            String json = mSharedPrefs.getString("urls", null);
            mChatUnreadChannel = mJsonHelper.fromJson(json, CallNotificationMap.class);
            if (mChatUnreadChannel == null) {
                mChatUnreadChannel = new HashMap<>();
            }
        }
        return mChatUnreadChannel;
    }

    public void setPath(Map<String, String> path) {
        this.mPath = path;
        String json = mJsonHelper.toJson(mPath);

        mSharedPrefsEditor.putString("path", json);
        mSharedPrefsEditor.commit();
    }

    public Map<String, String> getPath() {
        if (mPath == null) {
            String json = mSharedPrefs.getString("path", null);
            mPath = mJsonHelper.fromJson(json, CallNotificationMap.class);
            if (mPath == null) {
                mPath = new HashMap<>();
            }
        }
        return mPath;
    }

    public void setFileName(Map<String, String> fileName) {
        this.mFileName = fileName;
        String json = mJsonHelper.toJson(mFileName);

        mSharedPrefsEditor.putString("fileName", json);
        mSharedPrefsEditor.commit();
    }

    public Map<String, String> getFileName() {
        if (mFileName == null) {
            String json = mSharedPrefs.getString("fileName", null);
            mFileName = mJsonHelper.fromJson(json, CallNotificationMap.class);
            if (mFileName == null) {
                mFileName = new HashMap<>();
            }
        }
        return mFileName;
    }

    public String getAuthToken() {
        if (mToken == null) {
            mToken = mSharedPrefs.getString(PreferencesKeys.PREF_AUTH_TOKEN, null);
        }
        return mToken;
    }

    public void setAuthToken(String authToken) {
        this.mToken = authToken;
        mSharedPrefsEditor.putString(PreferencesKeys.PREF_AUTH_TOKEN, authToken);
        mSharedPrefsEditor.apply();
    }

    public User_detail getUserDetails() {
        if (mUserAccount == null) {
            String json = mSharedPrefs.getString(PreferencesKeys.PREF_USER_ACCOUNT_DETAILS, null);
            mUserAccount = mJsonHelper.fromJson(json, User_detail.class);
            if (mUserAccount == null) {
                mUserAccount = new User_detail();
            }
        }
        return mUserAccount;
    }

    public void setUserDetails(User_detail userAccount) {
        this.mUserAccount = userAccount;
        String json = mJsonHelper.toJson(userAccount);

        mSharedPrefsEditor.putString(PreferencesKeys.PREF_USER_ACCOUNT_DETAILS, json);
        mSharedPrefsEditor.apply();
    }

    public void logout() {
        setAuthToken(null);
        setUserDetails(new User_detail());
    }

    //region Helper classes
    private static class CallNotificationMap extends HashMap<String, String> {
    }
    //endregion
}
