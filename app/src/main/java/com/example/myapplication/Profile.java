package com.example.myapplication;

public class Profile {
    private  static volatile  Profile sSingleton = new Profile();
    private String nickname;
    private String url;

    private Profile() {}

    public static Profile getSingleton() {
        return sSingleton;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
