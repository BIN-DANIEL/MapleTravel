package com.maple.spring.dao;




import com.maple.spring.entity.User;

import java.util.List;

public interface AdminDao {
    public boolean hasUser(String username);
    public boolean addUser(User user);
    public boolean deleteUser(String username);
    public User getUser(String username);
}
