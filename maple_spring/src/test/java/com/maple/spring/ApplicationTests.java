package com.maple.spring;

import com.maple.spring.dao.AdminDao;
import com.maple.spring.dao.AdminDaoImpl;
import com.maple.spring.entity.User;
import org.junit.Test;
import static org.junit.Assert.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class ApplicationTests {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    AdminDao adminDao;

    User test = new User();
    private static final String userTable = "User";
    private static final String nonexistentUser = "test123456test123456";
    private static final String normalTestUserName = "test123456";
    private static final String normalTestPassword = "123456789";

    @BeforeEach
    public void setUser(){
        test.setUsername(normalTestUserName);
        test.setPassword(normalTestPassword);
    }

    @Test
    public void testCreateUserTable(){
        String sql = "SELECT COUNT(*) FROM " + userTable;
        int numOfCars = jdbcTemplate.queryForObject(sql, Integer.class);
        assertNotEquals(0, numOfCars);
    }

    @Test
    public void testHasUserNonExistent() {
        assertFalse(adminDao.hasUser(nonexistentUser));
    }

    @Test
    public void testHasUserExisting() {
        adminDao.addUser(test);
        assertTrue(adminDao.hasUser(nonexistentUser));
    }

    @Test
    public void testAddUser() {
        User tempUser = new User();
        tempUser.setPassword("999999999");
        tempUser.setUsername("temp");
        adminDao.addUser(tempUser);
        assertTrue(adminDao.hasUser(tempUser.getUsername()));
    }

    @Test
    public void testAddUserIdempotent() {
        adminDao.addUser(test);
        adminDao.addUser(test);
        assertTrue(adminDao.hasUser(test.getUsername()));
    }

    @Test
    public void testDeleteUserIdempotent() {
        adminDao.addUser(test);
        adminDao.deleteUser(test.getUsername());
        assertFalse(adminDao.hasUser(test.getUsername()));
    }

    @Test
    public void testDeleteNonExistentUserNoException() {
        try {
            adminDao.deleteUser(nonexistentUser);
        } catch (Exception e){
            fail();
        }
        assertTrue(true);
    }
}