package com.text.ysq.lanrenzhoumo.Tools;

import android.util.Log;

/**
 * Created by ysq on 2016/10/25.
 */
public class LogUtils {

    private static final String TAG = "android";
    private static final boolean DEBUG = false;

    public static void LOG(Class clazz , String log){
        if (DEBUG){
            Log.i(TAG, clazz.getName()+"---> "+log);
        }
    }
}
