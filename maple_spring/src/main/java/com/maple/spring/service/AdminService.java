package com.maple.spring.service;


import com.maple.spring.dao.AdminDao;
import com.maple.spring.entity.Course;
import com.maple.spring.entity.Enrollment;
import com.maple.spring.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AdminService {
    @Autowired
    AdminDao adminDao;

    public boolean hasUser(String username) {
        return adminDao.hasUser(username);
    }

    public boolean hasCourse(String name){
        return adminDao.hasCourse(name);
    }

    public boolean addUser(User user) {
        return adminDao.addUser(user);
    }

    public boolean addCourse(String courseName, String description, String link){
        return adminDao.addCourse(new Course(courseName, description, link));
    }

    public boolean deleteUser(String username) {
        return adminDao.deleteUser(username);
    }

    public boolean deleteCourse(String courseName){
        return adminDao.deleteCourse(courseName);
    }

    public boolean enrollCourse(String username, String courseName){
        return adminDao.enrollCourse(new Enrollment(username, courseName));
    }

    public boolean dropCourse(String username, String courseName){
        return adminDao.dropCourse(new Enrollment(username, courseName));
    }

    public String getCourseDescription(String courseName){
        return adminDao.getCourseDescription(courseName);
    }

    public String getCourseLink(String courseName){
        return adminDao.getCourseLink(courseName);
    }

    public ArrayList<String> getUserCourses(String username){
        return adminDao.getUserCourses(username);
    }

    public User getUser(String username) {
        return adminDao.getUser(username);
    }
}
