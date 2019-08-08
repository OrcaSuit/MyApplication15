package com.example.myapplication;

import java.util.UUID;

public class MemberVO {
    private UUID mUUID;
    public Long mid;
    public String name;
    public String iconUrl;

    public MemberVO() {
        mUUID = UUID.randomUUID();
    }

    public Long getUUID() {
        return mid;
    }

    public void setUUID(Long UUID) {
        mid = UUID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }
}
