package com.ms.chatapp.models;

import android.os.Build;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class User {
    private String userID;
    private String username;
    private String password;
    private String name;
    private boolean isActive;
    private long lastActive;
    private String avatar;
    private String email;
    public User(){

    }
    public User(String userID, String username, String password, String name, String avatar, String email) {
        this.userID = userID;
        this.username = username;
        this.password = password;
        this.name = name;
        this.isActive = false;

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            ZonedDateTime zdt = ZonedDateTime.of(LocalDateTime.now(), ZoneId.systemDefault());
            this.lastActive = zdt.toInstant().toEpochMilli();
        }
        this.avatar = avatar;
        this.email = email;
    }
    
    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public long getLastActive() {
        return lastActive;
    }

    public void setLastActive(long lastActive) {
        this.lastActive = lastActive;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
