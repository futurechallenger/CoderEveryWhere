package com.service.codereverywhere.codereverywhere.util;

import com.service.codereverywhere.codereverywhere.Application.MainApplication;
import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by uncle_charlie on 26/9/15.
 */
public class PreferenceUtil {
    private static final String APP_UUID_KEY = "APP_UUID_KEY";
    private static final String CONFIG_DEBUG_KEY = "CONFIG_DEBUG_KEY";
    private static final boolean DEFAULT_DEBUG_STATE = true;

    private static SharedPreferences _preferences;

    public static final SharedPreferences getPreferences() {
        if (_preferences == null) {
            _preferences = MainApplication.getApplicationInstance().getSharedPreferences(
                    MainApplication.getApplicationInstance().getPackageName(), Context.MODE_PRIVATE);
        }
        return _preferences;
    }

    public static String getAppUUID() {
        return getPreferences().getString(APP_UUID_KEY, "0");
    }

    public static void setAppUUID(String uuid) {
        getPreferences().edit().putString(APP_UUID_KEY, uuid).commit();
    }

    public static void setDebug(boolean debug) {
        getPreferences().edit().putBoolean(CONFIG_DEBUG_KEY, debug).commit();
    }

    public static boolean getDebug() {
        return getPreferences().getBoolean(CONFIG_DEBUG_KEY, DEFAULT_DEBUG_STATE);
    }
}
