package com.maple.spring.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class DataBaseDaoImpl implements DataBaseDao {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Override
    public void createUserTable() {
        String sql = "CREATE TABLE User(username CHAR(255) PRIMARY KEY," +
                "password CHAR(255))";
        jdbcTemplate.execute(sql);
    }
}
