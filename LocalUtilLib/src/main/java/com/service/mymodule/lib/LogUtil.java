package com.service.mymodule.lib;

import android.content.SharedPreferences;
import android.util.Log;

/**
 * Created by uncle_charlie on 26/9/15.
 */
public class LogUtil {

    private static final String LOG_TAG = "MyApp";

    private static boolean debugMode = true;

    public static void info(String event, int id, String format) {
        if (LogUtil.getDEBUG()) {
            Log.i(String.format("LOG_TAG: '%s' LOG_EVENT: '%s' EVENT_ID: '%d'", LOG_TAG, event, id), format);
        }
    }

    public static void warn(String event, int id, String format) {
        if (LogUtil.getDEBUG()) {
            Log.w(String.format("LOG_TAG:'%s' LOG_EVENT:'%s' EVENT_ID:'%d'", LOG_TAG, event, id), format);
        }
    }

    public static void error(String event, int id, String format) {
        if (LogUtil.getDEBUG()) {
            Log.e(String.format("LOG_TAG:'%s' LOG_EVENT:'%s' EVENT_ID:'%d'", LOG_TAG, event, id), format);
        }
    }

    public static void error(String event, String format) {
        if (LogUtil.getDEBUG()) {
            Log.e(String.format("LOG_TAG:'%s' LOG_EVENT:'%s'", LOG_TAG, event), format);
        }
    }

    public static void debug(String event, int id, String format) {
        if (LogUtil.getDEBUG()) {
            Log.d(String.format("LOG_TAG:'%s' LOG_EVENT:'%s' EVENT_ID:'%d'", LOG_TAG, event, id), format);
        }
    }

    public static boolean getDEBUG() {
        return debugMode;
    }

    public static void setDEBUG(boolean dm) {
        LogUtil.debugMode = debugMode;
    }
}
