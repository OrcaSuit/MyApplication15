package com.example.myapplication;

import com.kakao.auth.IApplicationConfig;
import com.kakao.auth.IPushConfig;
import com.kakao.auth.ISessionConfig;
import com.kakao.auth.KakaoAdapter;

public class KakaoSDKAdapter extends KakaoAdapter {
    @Override
    public ISessionConfig getSessionConfig() {
        return super.getSessionConfig();
    }

    @Override
    public IApplicationConfig getApplicationConfig() {
        return MyApp::getMyapplApplicationContext;
    }
}
