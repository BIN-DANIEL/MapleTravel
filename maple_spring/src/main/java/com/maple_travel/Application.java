package com.maple_travel;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


/**
 * 标注一个主程序
 */
@SpringBootApplication
public class Application implements WebMvcConfigurer{
    public static void main(String[] args) {

        ApplicationContext app = SpringApplication.run(Application.class, args);
        /** DataBase Initialization **/
//        DataBaseDao dataBaseDao = (DataBaseDao) app.getBean("dataBaseDaoImpl");
//        dataBaseDao.createUserTable();
//        dataBaseDao.createUserInfoTable();
//        dataBaseDao.createItemTable();
//        dataBaseDao.createItemImageTable();
        /** Start the Application **/
    }
}
