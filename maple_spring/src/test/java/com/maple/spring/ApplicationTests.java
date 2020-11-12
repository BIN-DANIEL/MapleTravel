package com.maple.spring;

import com.maple.spring.dao.AdminDao;
import com.maple.spring.entity.User;
import org.junit.Test;
import static org.junit.Assert.*;
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

    private static final String userTable = "User";
    private static final String courseTable = "Course";
    private static final String enrollmentTable = "Enrollment";
    private static final String nonexistentUser = "test123456test123456";
    private static final String normalTestUserName = "test123456";
    private static final String normalTestPassword = "123456789";
    private final User test = new User(normalTestUserName, normalTestPassword);

    @Test
    public void testCreateUserTable(){
        String checkExistSql = "select count(*) from information_schema.tables where table_name = ?";
        Integer num = jdbcTemplate.queryForObject(checkExistSql, new Object[]{ userTable }, Integer.class);
        if(num == null){
            fail();
        }
        assertNotEquals(0, num.intValue());
    }

    @Test
    public void testCreateCourseTable(){
        String checkExistSql = "select count(*) from information_schema.tables where table_name = ?";
        Integer num = jdbcTemplate.queryForObject(checkExistSql, new Object[]{ courseTable }, Integer.class);
        if(num == null){
            fail();
        }
        assertNotEquals(0, num.intValue());
    }

    @Test
    public void testCreateEnrollmentTable(){
        String checkExistSql = "select count(*) from information_schema.tables where table_name = ?";
        Integer num = jdbcTemplate.queryForObject(checkExistSql, new Object[]{ enrollmentTable }, Integer.class);
        if(num == null){
            fail();
        }
        assertNotEquals(0, num.intValue());
    }

    @Test
    public void testHasUserNonExistent() {
        assertFalse(adminDao.hasUser(nonexistentUser));
    }

    @Test
    public void testHasUserExisting() {
        adminDao.addUser(test);
        assertTrue(adminDao.hasUser(test.getUsername()));
    }

    @Test
    public void testAddUser() {
        User tempUser = new User("temp", "999999999");
        adminDao.addUser(tempUser);
        assertTrue(adminDao.hasUser(tempUser.getUsername()));
        adminDao.deleteUser(tempUser.getUsername());
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
    public void testSequentialAddDeleteUser() {
        String sql = "SELECT COUNT(*) FROM " + userTable;
        Integer numUserBefore = jdbcTemplate.queryForObject(sql, Integer.class);
        if(numUserBefore == null){
            fail();
        }
        for(int i = 0; i < 100; i++){
            adminDao.addUser(new User(Integer.toString(i + 100000), Integer.toString(i + 100000)));
        }
        for(int i = 0; i < 100; i++){
            adminDao.deleteUser(Integer.toString(i + 100000));
        }
        Integer numUserAfter = jdbcTemplate.queryForObject(sql, Integer.class);
        if(numUserAfter == null){
            fail();
        }
        assertEquals(numUserBefore, numUserAfter);
    }

    @Test
    public void testDeleteNonExistentUserNoException() {
        try {
            adminDao.deleteUser(nonexistentUser);
        } catch (Exception e){
            e.printStackTrace();
            fail();
        }
        assertTrue(true);
    }
}