package com.example.chengyonghui.xmlexample.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

/**
 * Created by chengyonghui on 2017/9/19.
 */
public class FirstService extends Service {
    @Override
    public IBinder onBind(Intent intent) {
        System.out.println("Service onBind");
        return null;
    }

    //当创建一个Service对象之后，会首先调用这个函数
    @Override
    public void onCreate() {
        super.onCreate();
        System.out.println("Service onCreate");
    }

    //当启动service会调用，比如播放mp3文件,决定Intent要做什么
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        System.out.println("flags--->" + flags);
        System.out.println("startId ---->" + startId);
        System.out.println("Service onStartCommand");
        return START_NOT_STICKY;
    }

    @Override
    public void onDestroy() {
        System.out.println("Service onDestroy");
        super.onDestroy();
    }
}
