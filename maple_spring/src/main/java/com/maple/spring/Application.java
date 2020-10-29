package com.maple.spring;

import com.maple.spring.dao.DataBaseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class Application {
    @Autowired
    DataBaseDao dataBaseDao;
    public static void main(String[] args) {
        ApplicationContext app = SpringApplication.run(Application.class, args);
//        DataBaseDao dataBaseDao = (DataBaseDao) app.getBean("dataBaseDaoImpl");
//        dataBaseDao.createUserTable();
    }

}
