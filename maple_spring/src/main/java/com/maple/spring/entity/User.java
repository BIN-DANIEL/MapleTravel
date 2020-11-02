package com.maple.spring.entity;

/**
 * Entity Class for User
 * @ PrimaryKey{username}
 * @ ForeignKey{username} --> UserInfo Table
 */
public class User {
    private String username;
    private String password;

    public User(String name, String pass){
        this.username = name;
        this.password = pass;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() { return password; }

    public void setPassword(String password) {
        this.password = password;
    }

    public String toString(){ return "|name:" + this.username + "|pass:" + this.password + "|"; }
}
