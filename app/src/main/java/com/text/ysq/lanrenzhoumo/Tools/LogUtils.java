package com.text.ysq.lanrenzhoumo.Tools;

import android.util.Log;

/**
 * Created by ysq on 2016/10/25.
 */
public class LogUtils {
    public static final String PATH = "http://api.lanrenzhoumo.com/main/recommend/index?v=3&session_id=000040a3fb7d64ce1737c6c7bb3c7e4e157c91&lon=114.30963859310197&page=1&lat=30.575388756810078";
    public static final String TAG = "android";
    public static final boolean DEBUG = false;

    public String getPATH() {
        return PATH;
    }

    public static String getTAG() {
        return TAG;
    }

    public static boolean isDEBUG() {
        return DEBUG;
    }

    public static void LOG(Class clazz , String log){
        if (DEBUG){
            Log.i(TAG, clazz.getName()+"---> "+log);
        }
    }
}
