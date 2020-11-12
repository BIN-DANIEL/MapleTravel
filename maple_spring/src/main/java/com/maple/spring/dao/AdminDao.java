package com.maple.spring.dao;




import com.maple.spring.entity.*;

import java.util.ArrayList;

public interface AdminDao {
    public boolean hasUser(String username);
    public boolean hasCourse(String name);
    public boolean addUser(User user);
    public boolean addCourse(Course course);
    public boolean deleteUser(String username);
    public boolean deleteCourse(String username);
    public boolean enrollCourse(String username, String courseName);
    public boolean dropCourse(String username, String courseName);
    public String getCourseDescription(String courseName);
    public String getCourseLink(String courseName);
    public ArrayList<String> getUserCourses(String username);
    public User getUser(String username);
}
