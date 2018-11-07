package com.onebee.rpgcontrol.app;

import android.util.Log;

public class LogUtil {

    public static void d(String str) {
        Log.d("Game",
            Thread.currentThread().getStackTrace()[4].getFileName() + ":" + Thread.currentThread()
                .getStackTrace()[4].getLineNumber() + " [" + str + "]");
    }

    public static void d() {
        Log.d("Game",
            "" + Thread.currentThread().getStackTrace()[4].getFileName() + Thread.currentThread()
                .getStackTrace()[4].getLineNumber());
    }
}
