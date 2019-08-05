package com.example.myapplication;

import android.app.Application;
import android.graphics.Bitmap;
import android.util.LruCache;


import com.kakao.auth.KakaoSDK;

public class MyApp extends Application {
    private static volatile MyApp instance = null;

    public static MyApp getMyAppContext(){
        if(instance == null)
            throw new IllegalStateException("this application does not inherit");
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        KakaoSDK.init(new KakaoSDKAdapter());

    }


    @Override
    public void onTerminate() {
        super.onTerminate();
        instance = null;
    }
}
