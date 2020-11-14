package com.maple.spring;

import com.maple.spring.dao.AdminDao;
import com.maple.spring.entity.Course;
import com.maple.spring.entity.Enrollment;
import com.maple.spring.entity.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import org.junit.runner.RunWith;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Method;

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
    private static final User nonexistentUser = new User("NULL", "NULL");
    private static final Course nonexistentCourse = new Course("CS506", "Software Engineering", "www.google.com");
    private static final Enrollment nonexistentEnrollment = new Enrollment("66AB", "CS577");
    private static final User normalTestUser = new User("test123456", "123456789");
    private static final Course normalTestCourse = new Course("Camping101", "Learn to be a camper", "zoom.whatever.com/3322");
    private static final Enrollment normalTestEnrollment = new Enrollment("66AB", "CS506");
    private static boolean setUpIsDone = false;
    private static int totalTests;
    private static int testsRan;

    @Before
    public void setUp(){
        if(!setUpIsDone){
            System.out.println("-------------SETUP-------------");
            setUpIsDone = true;
            totalTests = 0;
            Method[] methods = ApplicationTests.class.getMethods();
            for (Method method : methods) {
                if (method.getAnnotation(Test.class) != null) {
                    totalTests++;
                }
            } // get the number of tests that will run
            adminDao.addUser(normalTestUser);
            adminDao.addCourse(normalTestCourse);
            adminDao.enrollCourse(normalTestEnrollment);
        }
    }

    @After
    public void tearDown(){
        testsRan++;
        if(testsRan == totalTests){
            System.out.println("-------------TEARDOWN-------------");
            adminDao.deleteUser(normalTestUser.getUsername());
            adminDao.deleteCourse(normalTestCourse.getCourseName());
            adminDao.dropCourse(normalTestEnrollment);
        }
    }

    @Test
    public void testCreateUserTable(){
        String checkExistSql = "select count(*) from information_schema.tables where table_name = ?";
        Integer num = jdbcTemplate.queryForObject(checkExistSql, new Object[]{ userTable }, Integer.class);
        if(num == null){
            fail("JDBC Query Error");
        }
        assertNotEquals(0, num.intValue());
    }

    @Test
    public void testCreateCourseTable(){
        String checkExistSql = "select count(*) from information_schema.tables where table_name = ?";
        Integer num = jdbcTemplate.queryForObject(checkExistSql, new Object[]{ courseTable }, Integer.class);
        if(num == null){
            fail("JDBC Query Error");
        }
        assertNotEquals(0, num.intValue());
    }

    @Test
    public void testCreateEnrollmentTable(){
        String checkExistSql = "select count(*) from information_schema.tables where table_name = ?";
        Integer num = jdbcTemplate.queryForObject(checkExistSql, new Object[]{ enrollmentTable }, Integer.class);
        if(num == null){
            fail("JDBC Query Error");
        }
        assertNotEquals(0, num.intValue());
    }

    @Test
    public void testHasUserNonExistent() {
        assertFalse(adminDao.hasUser(nonexistentUser.getUsername()));
    }

    @Test
    public void testHasCourseNonExistent() {
        assertFalse(adminDao.hasCourse(nonexistentCourse.getCourseName()));
    }

    @Test
    public void testHasEnrollmentNonExistent() {
        assertFalse(adminDao.hasEnrollment(nonexistentEnrollment));
    }

    @Test
    public void testHasUserExisting() {
        assertTrue(adminDao.hasUser(normalTestUser.getUsername()));
    }

    @Test
    public void testHasCourseExisting() {
        assertTrue(adminDao.hasCourse(normalTestCourse.getCourseName()));
    }

    @Test
    public void testHasEnrollmentExisting() {
        assertTrue(adminDao.hasEnrollment(normalTestEnrollment));
    }

    @Test
    public void testAddUser() {
        User tempUser = new User("temp", "999999999");
        adminDao.addUser(tempUser);
        assertTrue(adminDao.hasUser(tempUser.getUsername()));
        adminDao.deleteUser(tempUser.getUsername());
    }

    @Test
    public void testAddCourse() {
        Course tempCourse = new Course("Bonfire", "how to lit a bonfire", "www.steam.com");
        adminDao.addCourse(tempCourse);
        assertTrue(adminDao.hasCourse(tempCourse.getCourseName()));
        adminDao.deleteCourse(tempCourse.getCourseName());
    }

    @Test
    public void testEnroll() {
        Enrollment tempEnrollment = new Enrollment("66AB", "CS999");
        adminDao.enrollCourse(tempEnrollment);
        assertTrue(adminDao.hasEnrollment(tempEnrollment));
        adminDao.dropCourse(tempEnrollment);
    }

    @Test
    public void testAddUserIdempotent() {
        adminDao.addUser(normalTestUser);
        adminDao.addUser(normalTestUser);
        adminDao.deleteUser(normalTestUser.getUsername());
        assertFalse(adminDao.hasUser(normalTestUser.getUsername()));
        adminDao.addUser(normalTestUser);
        assertTrue(adminDao.hasUser(normalTestUser.getUsername()));
    }

    @Test
    public void testAddCourseIdempotent() {
        adminDao.addCourse(normalTestCourse);
        adminDao.addCourse(normalTestCourse);
        adminDao.deleteCourse(normalTestCourse.getCourseName());
        assertFalse(adminDao.hasCourse(normalTestCourse.getCourseName()));
        adminDao.addCourse(normalTestCourse);
        assertTrue(adminDao.hasCourse(normalTestCourse.getCourseName()));
    }

    @Test
    public void testEnrollIdempotent(){
        adminDao.enrollCourse(normalTestEnrollment);
        adminDao.enrollCourse(normalTestEnrollment);
        adminDao.dropCourse(normalTestEnrollment);
        assertFalse(adminDao.hasEnrollment(normalTestEnrollment));
        adminDao.enrollCourse(normalTestEnrollment);
        assertTrue(adminDao.hasEnrollment(normalTestEnrollment));
    }

    @Test
    public void testDeleteUserIdempotent() {
        adminDao.deleteUser(normalTestUser.getUsername());
        adminDao.deleteUser(normalTestUser.getUsername());
        assertFalse(adminDao.hasUser(normalTestUser.getUsername()));
        adminDao.addUser(normalTestUser);
    }

    @Test
    public void testDeleteCourseIdempotent() {
        adminDao.deleteCourse(normalTestCourse.getCourseName());
        adminDao.deleteCourse(normalTestCourse.getCourseName());
        assertFalse(adminDao.hasCourse(normalTestCourse.getCourseName()));
        adminDao.addCourse(normalTestCourse);
    }

    @Test
    public void testDropCourseIdempotent(){
        adminDao.dropCourse(normalTestEnrollment);
        adminDao.dropCourse(normalTestEnrollment);
        assertFalse(adminDao.hasEnrollment(normalTestEnrollment));
        adminDao.enrollCourse(normalTestEnrollment);
    }

    /*
       Small scale stress tests for performance
    */
    @Test
    public void testSequentialAddDeleteUser() {
        String sql = "SELECT COUNT(*) FROM " + userTable;
        Integer numUserBefore = jdbcTemplate.queryForObject(sql, Integer.class);
        if(numUserBefore == null){
            fail("JDBC Query Error");
        }
        for(int i = 0; i < 100; i++){
            adminDao.addUser(new User(nonexistentUser.getUsername() + i, Integer.toString(i + 100000)));
        }
        for(int i = 0; i < 100; i++){
            adminDao.deleteUser(nonexistentUser.getUsername() + i);
        }
        for(int i = 0; i < 100; i++){
            if(adminDao.hasUser(nonexistentUser.getUsername() + i)) {
                fail("Database has remaining records after deletion");
            }
        }
        Integer numUserAfter = jdbcTemplate.queryForObject(sql, Integer.class);
        if(numUserAfter == null){
            fail("JDBC Query Error");
        }
        assertEquals(numUserBefore, numUserAfter);
    }

    @Test
    public void testSequentialAddDeleteCourse() {
        String sql = "SELECT COUNT(*) FROM " + courseTable;
        Integer numUserBefore = jdbcTemplate.queryForObject(sql, Integer.class);
        if(numUserBefore == null){
            fail("JDBC Query Error");
        }
        for(int i = 0; i < 100; i++){
            adminDao.addCourse(new Course(nonexistentCourse.getCourseName() + i, "Intro to Camping" + i, "www.camping.com/" + i));
        }
        for(int i = 0; i < 100; i++){
            adminDao.deleteCourse(nonexistentCourse.getCourseName() + i);
        }
        for(int i = 0; i < 100; i++){
            if(adminDao.hasCourse(nonexistentCourse.getCourseName() + i)){
                fail("Database has remaining records after deletion");
            }
        }
        Integer numUserAfter = jdbcTemplate.queryForObject(sql, Integer.class);
        if(numUserAfter == null){
            fail("JDBC Query Error");
        }
        assertEquals(numUserBefore, numUserAfter);
    }

    @Test
    public void testSequentialEnrollDropCourse() {
        String sql = "SELECT COUNT(*) FROM " + enrollmentTable;
        Integer numUserBefore = jdbcTemplate.queryForObject(sql, Integer.class);
        if(numUserBefore == null){
            fail("JDBC Query Error");
        }
        for(int i = 0; i < 100; i++){
            adminDao.enrollCourse(new Enrollment("77BC" + i + 100000, "Intro to Camping" + i + 100000));
        }
        for(int i = 0; i < 100; i++){
            adminDao.dropCourse(new Enrollment("77BC" + i + 100000, "Intro to Camping" + i + 100000));
        }
        for(int i = 0; i < 100; i++){
            if(adminDao.hasEnrollment(new Enrollment("77BC" + i + 100000, "Intro to Camping" + i + 100000))){
                fail("Database has remaining records after deletion");  // fail if some records remained in the database
            }
        }
        Integer numUserAfter = jdbcTemplate.queryForObject(sql, Integer.class);
        if(numUserAfter == null){
            fail("JDBC Query Error");
        }
        assertEquals(numUserBefore, numUserAfter);
    }
    // End of stress tests

    // Tests removing certain entities will not throw exception
    // Exception is implicitly handled by Junit
    @Test
    public void testDeleteNonExistentUserNoException() {
        try {
            adminDao.deleteUser(nonexistentUser.getUsername());
        } catch (Exception e){
            e.printStackTrace();
            fail("Exception thrown");
        }
    }

    @Test
    public void testDeleteNonExistentCourseNoException() {
        try {
            adminDao.deleteCourse(nonexistentCourse.getCourseName());
        } catch (Exception e){
            e.printStackTrace();
            fail("Exception thrown");
        }
    }

    @Test
    public void testDropNonExistentCourseNoException() {
        try {
            adminDao.dropCourse(nonexistentEnrollment);
        } catch (Exception e){
            e.printStackTrace();
            fail("Exception thrown");
        }
    }

    @Test
    public void testGetUser(){
        assertEquals(normalTestUser, adminDao.getUser(normalTestUser.getUsername()));
    }
}