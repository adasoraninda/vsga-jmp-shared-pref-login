package com.vsgajmpa.loginsharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

// We can use getSharedPreferences directly
public class Preferences {
    public static final String KEY_USERNAME = "USERNAME";

    // Default mode PRIVATE
    private static SharedPreferences getSharedPreferences(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context);
    }

    public static void registerUser(Context context, String username) {
        SharedPreferences sharedPreferences = getSharedPreferences(context);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(KEY_USERNAME, username);
        editor.apply();
    }

    public static String getUser(Context context) {
        return getSharedPreferences(context).getString(KEY_USERNAME, null);
    }

    public static void unregisterUser(Context context) {
        SharedPreferences sharedPreferences = getSharedPreferences(context);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove(KEY_USERNAME);
        editor.apply();
    }

}
