package com.maple.spring.dao;

import com.maple.spring.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

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
    public User getUser(String username) {
        String sql = "Select * from " + userTable + " where username=?";
        try{
            return jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<>(User.class),username);
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }
}
