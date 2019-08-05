package com.example.myapplication;

import android.content.Context;

import androidx.annotation.Nullable;

import com.kakao.auth.ApprovalType;
import com.kakao.auth.AuthType;
import com.kakao.auth.IApplicationConfig;
import com.kakao.auth.ISessionConfig;
import com.kakao.auth.KakaoAdapter;

public class KakaoSDKAdapter extends KakaoAdapter {
    // 로그인 시 사용 될, Session의 옵션 설정을 위한 인터페이스
    @Override
    public ISessionConfig getSessionConfig() {
        return new ISessionConfig() {
            @Override
            public AuthType[] getAuthTypes() {
                return new AuthType[] {AuthType.KAKAO_ACCOUNT};
            }

            @Override
            public boolean isUsingWebviewTimer() {
                return false;
            }

            @Override
            public boolean isSecureMode() {
                return false;
            }

            @Nullable
            @Override
            public ApprovalType getApprovalType() {
                return null;
            }

            @Override
            public boolean isSaveFormData() {
                return false;
            }
        };
    }

    @Override
    public IApplicationConfig getApplicationConfig() {
       return MyApp::getMyAppContext; //SDK 1.8
    }
}