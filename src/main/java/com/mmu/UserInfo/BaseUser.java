package com.mmu.UserInfo;

import java.io.Serializable;

public class BaseUser implements Serializable {
    protected String name;
    private String username;
    private String password;

    // This is the admins details
    public static final BaseUser adminUser = new BaseUser("Admin", "admin", "root");

    public BaseUser(String name, String username, String password) {
        this.name = name;
        this.username = username;
        this.password = password;
    }

    // this checks if the password and username of the Admin is correct
    public static boolean isMatch(String password, String username) {
        if (password.equals("root") && username.equals("admin")) {
            return true;
        } else {
            return false;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}
