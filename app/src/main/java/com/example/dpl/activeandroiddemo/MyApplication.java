package com.example.dpl.activeandroiddemo;

import android.app.Application;

import com.activeandroid.ActiveAndroid;

/**
 * Created by dpl on 2017/10/2 0002.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ActiveAndroid.initialize(this);//用initialize的重载方法开启
    }
}
