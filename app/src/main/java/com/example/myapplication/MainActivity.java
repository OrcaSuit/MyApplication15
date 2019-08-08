package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.kakao.auth.AuthType;

import com.kakao.auth.ISessionCallback;
import com.kakao.auth.Session;
import com.kakao.network.ErrorResult;
import com.kakao.usermgmt.LoginButton;
import com.kakao.usermgmt.UserManagement;
import com.kakao.usermgmt.callback.MeV2ResponseCallback;
import com.kakao.usermgmt.response.MeV2Response;
import com.kakao.util.exception.KakaoException;
import com.kakao.util.helper.log.Logger;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private SessionCallback mCallback;

    LoginButton btn_kakao;
    Button update;
    ImageView imgView;
    TextView textView;

    MemberVO mMemberVO;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mCallback = new SessionCallback();
        Session.getCurrentSession().addCallback(mCallback);
    }

    private  class SessionCallback implements ISessionCallback {
        @Override
        public void onSessionOpened() {
            reqeustMe();
        }

        @Override
        public void onSessionOpenFailed(KakaoException exception) {

        }

        private void reqeustMe(){
            List<String> keys = new ArrayList<>();
            keys.add("properties.nickname");
            keys.add("properties.profile_image");


            UserManagement.getInstance().me(keys, new MeV2ResponseCallback() {
                @Override
                public void onSessionClosed(ErrorResult errorResult) {

                }

                @Override
                public void onSuccess(MeV2Response result) {
                    Logger.d("id: " + result.getId());
                    Logger.d("profile image: " + result.getNickname());
                    Logger.d("profile image: " + result.getProfileImagePath());
                    MyApp.getMyAppContext().getMemberVO(
                    MyApp.getMyAppContext().getMemberVO(result.getId()).setName(result.getNickname());
                    MyApp.getMyAppContext().getMemberVO(result.getId()).setIconUrl(result.getProfileImagePath());

                }
            });
        }
    }
}
/*
        mMemberVO = ((MyApp)getApplication()).getMemberVO();


        imgView = (ImageView) findViewById(R.id.profile_pic);
        textView = (TextView) findViewById(R.id.nickname);

        btn_kakao = (LoginButton) findViewById(R.id.com_kakao_login);
        btn_kakao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Session session = Session.getCurrentSession();
                session.addCallback(new SessionCallback());
                session.open(AuthType.KAKAO_LOGIN_ALL, MainActivity.this);
            }
        });

        update = (Button) findViewById(R.id.update_btn);
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Session session = Session.getCurrentSession();
                session.addCallback(new SessionCallback());
                Glide.with(MainActivity.this).load(Profile.getSingleton().getUrl()).into(imgView);
                textView.setText(Profile.getSingleton().getNickname());
            }
        });

    }
    */


