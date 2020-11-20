package com.maple.spring.dao;

import com.maple.spring.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.concurrent.ThreadLocalRandom;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;


@Repository
public class DataBaseDaoImpl implements DataBaseDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    private static final String userTable = "User";
    private static final String courseTable = "Course";
    private static final String enrollmentTable = "Enrollment";

    @Override
    public void createUserTable() {
        String checkExistSql = "select count(*) from information_schema.tables where table_name = ?";
        Integer checkResult = jdbcTemplate.queryForObject(checkExistSql, new Object[] { userTable }, Integer.class);
        if(checkResult == null || checkResult == 0){
            String sql = "CREATE TABLE " + userTable + "(username CHAR(255) PRIMARY KEY," +
                    "password CHAR(255))";
            jdbcTemplate.execute(sql);
        }
    }

    @Override
    public void createCourseTable() {
        String checkExistSql = "select count(*) from information_schema.tables where table_name = ?";
        Integer checkResult = jdbcTemplate.queryForObject(checkExistSql, new Object[] { courseTable }, Integer.class);
        if(checkResult == null || checkResult == 0){
            String sql = "CREATE TABLE " + courseTable + "(courseName CHAR(255) PRIMARY KEY," +
                    "description CHAR(255)," + "link CHAR(255))";
            jdbcTemplate.execute(sql);
        }
    }

    @Override
    public void createEnrollmentTable() {
        String checkExistSql = "select count(*) from information_schema.tables where table_name = ?";
        Integer checkResult = jdbcTemplate.queryForObject(checkExistSql, new Object[] { enrollmentTable }, Integer.class);
        if(checkResult == null || checkResult == 0){
            String sql = "CREATE TABLE " + enrollmentTable + "(username CHAR(255)," +
                    "courseName CHAR(255))";
            jdbcTemplate.execute(sql);
        }
    }

    @Override
    public void loadDummyData(){
        BufferedReader reader;
        try {
            ArrayList<String> users = new ArrayList<String>();
            ArrayList<String> courses = new ArrayList<String>();
            reader = new BufferedReader(new FileReader("src/main/java/DummyCourses.txt"));
            String line = reader.readLine();
            while (line != null) {
                courses.add(line);
                Course course = new Course(line, getRandString(15), "www." + getRandString(15) + ".com");
                String checkExistSql = "select count(*) from " + courseTable + " where courseName=\'" + line + "\'";
                Integer checkResult = jdbcTemplate.queryForObject(checkExistSql, Integer.class);
                if(checkResult == null || checkResult == 0){
                    String sql = "INSERT INTO " + courseTable + " values(?, ?, ?)";
                    jdbcTemplate.update(sql, course.getCourseName(), course.getDescription(), course.getLink());
                }
                line = reader.readLine();
            }
            reader.close();
            reader = new BufferedReader(new FileReader("src/main/java/DummyStudents.txt"));
            line = reader.readLine();
            while (line != null) {
                users.add(line);
                String checkExistSql = "select count(*) from " + userTable + " where username=\'" + line + "\'";
                Integer checkResult = jdbcTemplate.queryForObject(checkExistSql, Integer.class);
                if(checkResult == null || checkResult == 0){
                    String sql = "INSERT INTO " + userTable + " values(?, ?)";
                    jdbcTemplate.update(sql, line, getRandString(8));
                }
                line = reader.readLine();
            }
            reader.close();
            for(int i = 0; i < users.size(); i++){
                HashSet<Integer> set = new HashSet<>();
                int numCourse = ThreadLocalRandom.current().nextInt(0, 6);
                for(int k = 0; k < numCourse; k++){
                    int idx = ThreadLocalRandom.current().nextInt(0, courses.size());
                    if(set.contains(idx)) {
                        k--;
                        continue;
                    }
                    set.add(idx);
                    String enrolled = courses.get(idx);
                    String checkExistSql = "select count(*) from " + enrollmentTable + " where username=\'" + users.get(i) + "\' AND courseName=\'" + enrolled + "\'";
                    Integer checkResult = jdbcTemplate.queryForObject(checkExistSql, Integer.class);
                    if(checkResult == null || checkResult == 0){
                        String sql = "INSERT INTO " + enrollmentTable + " values(?, ?)";
                        jdbcTemplate.update(sql, users.get(i), enrolled);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getRandString(int len) {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < len) { // length of the random string.
            int index = (int) (rnd.nextFloat() * chars.length());
            salt.append(chars.charAt(index));
        }
        return salt.toString();
    }
}
