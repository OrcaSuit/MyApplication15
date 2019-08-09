package com.example.myapplication;

import android.app.Application;

import com.kakao.auth.KakaoSDK;

public class MyApp extends Application {
    private static volatile MyApp instance = null;

    public static MyApp getMyapplApplicationContext() {
        if (instance == null)
            throw new IllegalStateException("this application does not inherit com.kakao.GlobalApplication");
        return instance;
    }

    public void onCreate() {
        super.onCreate();
        instance = this;
        KakaoSDK.init(new KakaoSDKAdapter());
    }
}
