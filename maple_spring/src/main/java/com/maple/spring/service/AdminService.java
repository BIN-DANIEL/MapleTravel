package com.maple.spring.service;


import com.maple.spring.dao.AdminDao;
import com.maple.spring.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    @Autowired
    AdminDao adminDao;

    public boolean hasUser(String username) {
        return adminDao.hasUser(username);
    }

    public boolean addUser(User user) {
        return adminDao.addUser(user);
    }

    public boolean deleteUser(String username) {
        return adminDao.deleteUser(username);
    }

    public User getUser(String username) {
        return adminDao.getUser(username);
    }
}
