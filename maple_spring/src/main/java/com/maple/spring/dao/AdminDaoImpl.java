package com.maple.spring.dao;

import com.maple.spring.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.*;


/**
 * schemas:
 * Item(itemId(Binary), title, description, price, username, coverImageId(Binary))
 * ItemImage(imageId(Binary), itemId(Binary), diskUrl, httpUrl)
 * User(username, password);
 * UserInfo(username, qq, weChat, phone, mail)
 */

@Repository
public class AdminDaoImpl implements AdminDao {
    private static final String userTable = "User";
    private static final String courseTable = "Course";
    private static final String enrollmentTable = "Enrollment";

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public boolean hasUser(String username) {
        String sql = "Select count(*) from " + userTable + " where username=?";
        Integer num = jdbcTemplate.queryForObject(sql, Integer.class, username);
        try{
            return num != null && num == 1;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean hasCourse(String courseName) {
        String sql = "Select count(*) from " + courseTable + " where courseName=?";
        Integer num = jdbcTemplate.queryForObject(sql, Integer.class, courseName);
        try{
            return num != null && num == 1;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean hasEnrollment(Enrollment enrollment) {
        try{
            String checkExistSql = "SELECT COUNT(*) FROM " + enrollmentTable + " WHERE username = ? AND courseName = ?";
            Integer checkResult = jdbcTemplate.queryForObject(checkExistSql, Integer.class, enrollment.getUsername(), enrollment.getCourseName());
            if(checkResult == null || checkResult == 0){
                return false;
            } else if (checkResult == 1){
                return true;
            } else {
                throw new Exception("Duplicated enrollment for student:" + enrollment.getUsername() + " for course" + enrollment.getCourseName());
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean addUser(User user){
        String sql = "Insert into " + userTable + " values(?, ?)";
        try{
            jdbcTemplate.update(sql, user.getUsername(), user.getPassword());
            return true;
        }  catch (DuplicateKeyException e){
            return true;   // Add user is idempotent, therefore it shouldn't throw error here
        } catch (DataAccessException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean addCourse(Course course){
        String sql = "Insert into " + courseTable + " values(?, ?, ?)";
        try{
            jdbcTemplate.update(sql, course.getCourseName(), course.getDescription(), course.getLink());
            return true;
        }  catch (DuplicateKeyException e){
            return true;   // Add course is idempotent, therefore it shouldn't throw error here
        } catch (DataAccessException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteUser(String username){
        try {
            String sql = "Delete from " + userTable + " where username=?";
            jdbcTemplate.update(sql, username);
            return true;
        } catch(DataAccessException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteCourse(String courseName){
        try {
            String sql = "Delete from " + courseTable + " where courseName=?";
            jdbcTemplate.update(sql, courseName);
            return true;
        } catch(DataAccessException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean enrollCourse(Enrollment enrollment) {
        try {
            if(!hasEnrollment(enrollment)){
                String sql = "INSERT INTO " + enrollmentTable + " values(?, ?)";
                jdbcTemplate.update(sql, enrollment.getUsername(), enrollment.getCourseName());
            }
            return true;
        } catch(DataAccessException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean dropCourse(Enrollment enrollment) {
        try {
            if(hasEnrollment(enrollment)){
                String sql = "DELETE FROM " + enrollmentTable + " WHERE username = ? AND courseName = ?";
                jdbcTemplate.update(sql, enrollment.getUsername(), enrollment.getCourseName());
            }
            return true;
        } catch(DataAccessException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public ArrayList<String> getUserCourses(String username){
        try {
            String sql = "SELECT courseName FROM " + enrollmentTable + " WHERE username = ?";
            List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql, username);
            ArrayList<String> res = new ArrayList<>();
            if(rows.size() != 0){
                for(Map<String, Object> map: rows){
                    res.add((String) map.get("courseName"));
                }
            }
            return res;
        } catch(DataAccessException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @Override
    public String getCourseDescription(String courseName){
        try {
            String sql = "SELECT description FROM " + courseTable + " WHERE courseName = ?";
            return jdbcTemplate.queryForObject(sql, new Object[] { courseName }, String.class);
        } catch(DataAccessException e) {
            return null;
        }
    }

    @Override
    public String getCourseLink(String courseName){
        try {
            String sql = "SELECT link FROM " + courseTable + " WHERE courseName = ?";
            return jdbcTemplate.queryForObject(sql, new Object[] { courseName }, String.class);
        } catch(DataAccessException e) {
            return null;
        }
    }

    @Override
    public User getUser(String username) {
        String sql = "Select * from " + userTable + " where username=?";
        try{
            return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(User.class),username);
        } catch (DataAccessException e) {
            return null;
        }
    }
}
