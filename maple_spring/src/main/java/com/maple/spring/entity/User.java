package com.maple.spring.entity;

/**
 * Entity Class for User
 * @ PrimaryKey{username}
 * @ ForeignKey{username} --> UserInfo Table
 */
public class User {
    private String username;

    public String getUsername() {
        return username;
    }

    private String password;

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
