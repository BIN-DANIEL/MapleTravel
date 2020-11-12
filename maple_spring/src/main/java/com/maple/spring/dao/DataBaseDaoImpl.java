package com.maple.spring.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class DataBaseDaoImpl implements DataBaseDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    private static final String userTable = "User";
    private static final String courseTable = "Course";
    private static final String enrollmentTable = "Enrollment";

    @Override
    public void createUserTable() {
        String checkExistSql = "SELECT COUNT(*) FROM" + userTable;
        Integer checkResult = jdbcTemplate.queryForObject(checkExistSql, Integer.class);
        if(checkResult == null || checkResult == 0){
            String sql = "CREATE TABLE " + userTable + "(username CHAR(255) PRIMARY KEY," +
                    "password CHAR(255))";
            jdbcTemplate.execute(sql);
        }
    }

    @Override
    public void createCourseTable() {
        String checkExistSql = "SELECT COUNT(*) FROM" + courseTable;
        Integer checkResult = jdbcTemplate.queryForObject(checkExistSql, Integer.class);
        if(checkResult == null || checkResult == 0){
            String sql = "CREATE TABLE " + courseTable + "(courseName CHAR(255) PRIMARY KEY," +
                    "description CHAR(255)," + "link CHAR(255))";
            jdbcTemplate.execute(sql);
        }
    }

    @Override
    public void createEnrollmentTable() {
        String checkExistSql = "SELECT COUNT(*) FROM" + enrollmentTable;
        Integer checkResult = jdbcTemplate.queryForObject(checkExistSql, Integer.class);
        if(checkResult == null || checkResult == 0){
            String sql = "CREATE TABLE " + courseTable + "(username CHAR(255) PRIMARY KEY," +
                    "courseName CHAR(255))";
            jdbcTemplate.execute(sql);
        }
    }
}
