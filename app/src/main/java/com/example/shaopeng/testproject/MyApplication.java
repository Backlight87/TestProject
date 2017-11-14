package com.example.shaopeng.testproject;

import android.app.Application;
import android.content.Context;

/**
 * 自定义application记得在manifest里面声明
 * Created by Administrator on 2017/11/13.
 */
public class MyApplication extends Application {
    private static MyApplication mApplication;

    public static Context getApplication() {
        //原定是在这里进行mApplication的赋值但是不允许在static方法里面赋值
        return mApplication;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mApplication = this;
    }
}
