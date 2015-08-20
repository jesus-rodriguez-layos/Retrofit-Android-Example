package com.jrdev9.sample.retrofit.model;

import com.google.gson.annotations.SerializedName;

public class User {
    public long id;
    @SerializedName("login")
    public String nick;
    public String name;
    public long followers;
    public long following;

    public long getId() {
        return id;
    }

    public String getNick() {
        return nick;
    }

    public String getName() {
        return name;
    }

    public long getFollowers() {
        return followers;
    }

    public long getFollowing() {
        return following;
    }
}