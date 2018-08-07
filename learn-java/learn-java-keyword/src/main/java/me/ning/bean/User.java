package me.ning.bean;

import java.io.Serializable;

public class User implements Serializable,Cloneable {

    private String username;
    transient private String password;

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

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
