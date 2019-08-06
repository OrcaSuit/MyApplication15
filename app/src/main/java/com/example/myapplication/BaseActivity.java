package com.example.myapplication;

import android.content.Intent;

import androidx.fragment.app.FragmentActivity;


//액티비티 분기를 위한 클래스
public abstract class BaseActivity extends FragmentActivity {
    
    protected void redirectLoginActivity() {
        final Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

}