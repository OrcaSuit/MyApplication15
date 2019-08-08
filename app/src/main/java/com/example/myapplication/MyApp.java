package com.example.myapplication;

import android.app.Application;
import android.content.Context;

import com.kakao.auth.IApplicationConfig;
import com.kakao.auth.KakaoAdapter;
import com.kakao.auth.KakaoSDK;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MyApp extends Application {
    private static volatile MyApp instance = null;
    private List<MemberVO> mMemberVOs;

    public static MyApp getMyAppContext() {
        if (instance == null)
            throw new IllegalStateException("this application does not inherit com.kakao.GlobalApplication");
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        KakaoSDK.init(new KakaoSDKAdapter());
    }

    private MyApp(Context context) {
        mMemberVOs = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            MemberVO memberVO = new MemberVO();
            mMemberVOs.add(memberVO);
        }

    }

    public List<MemberVO> getMemberVOs() {
        return mMemberVOs;
    }

    public MemberVO getMemberVO(Long id) {
        for (MemberVO memberVO : mMemberVOs) {
            if (memberVO.getUUID().equals(id)) {
                return memberVO;
            }
        }

        return null;
    }

    public MemberVO getMemberVO(Long id, ) {
        for (MemberVO memberVO : mMemberVOs) {
            if (memberVO.getUUID().equals(id)) {
                return memberVO;
            }
        }

        return null;
    }

    MemberVO member = new MemberVO();
        mMemberVOs.add(member);
}
