package com.ecut.teachingevalutionsystem.model.param;

public class UserParam {
    public String userName;
    public String password;
    public String identity;

    public String getUserId() {
        return userName;
    }

    public void setUserId(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return identity;
    }

    public void setType(String identity) {
        this.identity = identity;
    }
}
