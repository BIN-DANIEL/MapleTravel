package com.maple.spring.entity;

public class Enrollment {
    private String username;
    private String courseName;

    public Enrollment(){

    }

    public Enrollment(String username, String courseName){
        this.username = username;
        this.courseName = courseName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String toString(){
        return "Enrollment|name:" + this.username + "|course:" + this.courseName + "|";
    }
}
