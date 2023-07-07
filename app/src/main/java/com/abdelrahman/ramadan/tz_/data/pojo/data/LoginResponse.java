package com.abdelrahman.ramadan.tz_.data.pojo.data;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "response",strict = false)

public class LoginResponse {
    @Element(name = "auth")
    String auth;

    @Override
    public String toString() {
        return "LoginResponse{" +
                "auth='" + auth + '\'' +
                ", user=" + user +
                '}';
    }

    @Element(name = "user")
    User user;

    public String getAuth() {
        return auth;
    }

    public void setAuth(String auth) {
        this.auth = auth;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
