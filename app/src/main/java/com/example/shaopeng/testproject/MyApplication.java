package com.example.shaopeng.testproject;

import android.app.Application;
import android.content.Context;
/**
 * Created by Administrator on 2017/11/13.
 */
public class MyApplication extends Application {
    private static Context mApplication;

    public static void getApplication() {
        if (mApplication != null) {
            mApplication = new MyApplication();
        }
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }
}
