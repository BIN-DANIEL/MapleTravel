package com.maple.spring.entity;

public class Course {
    private String courseName;
    private String description;
    private String link;

    public Course() {

    }

    public Course(String name, String description, String link){
        this.courseName = name;
        this.description = description;
        this.link = link;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getDescription() {
        return description;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String toString() {
        return "Course|courseName:" + this.courseName + "|description:" + this.description + "|link:" + this.link + "|";
    }
}
