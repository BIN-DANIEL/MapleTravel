package com.maple.spring.dao;




import com.maple.spring.entity.*;

import java.util.ArrayList;

public interface AdminDao {
    boolean hasUser(String username);
    boolean hasCourse(String username);
    boolean hasEnrollment(Enrollment enrollment);
    boolean addUser(User user);
    boolean addCourse(Course course);
    boolean deleteUser(String username);
    boolean deleteCourse(String courseName);
    boolean enrollCourse(Enrollment enroll);
    boolean dropCourse(Enrollment enroll);
    String getCourseDescription(String courseName);
    String getCourseLink(String courseName);
    ArrayList<String> getUserCourses(String username);
    User getUser(String username);
}
