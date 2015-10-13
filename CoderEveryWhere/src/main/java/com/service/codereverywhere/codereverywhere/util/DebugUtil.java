package com.service.codereverywhere.codereverywhere.util;

/**
 * Created by uncle_charlie on 26/9/15.
 */
public class DebugUtil {
    public static boolean getDEBUG() {
        return PreferenceUtil.getDebug();
    }

    public static void setDEBUG(boolean dEBUG) {
        PreferenceUtil.setDebug(dEBUG);
    }


}
