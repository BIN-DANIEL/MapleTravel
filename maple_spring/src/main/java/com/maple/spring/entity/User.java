package com.maple.spring.entity;

import java.util.Objects;

/**
 * Entity Class for User
 * @ PrimaryKey{username}
 * @ ForeignKey{username} --> UserInfo Table
 */
public class User {
    private String username;
    private String password;
    public User(){

    }
    public User(String name, String pass){
        this.username = name;
        this.password = pass;
    }

    /*
        Used for user object comparison
     */
    @Override
    public boolean equals(Object o) {
        if (this == o){
            return true;
        }
        if (o == null) {
            return false;
        }
        if (getClass() != o.getClass()){
            return false;
        }
        User user = (User) o;
        return Objects.equals(username, user.getUsername())
                && Objects.equals(password, user.getPassword());
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

    public String toString(){ return "User|name:" + this.username + "|pass:" + this.password + "|"; }
}
