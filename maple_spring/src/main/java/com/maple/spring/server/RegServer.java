package com.maple.spring.server;

import com.maple.spring.entity.User;
import com.maple.spring.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * This is the server handling Register event
 */
@RestController
public class RegServer {
    @Autowired
    AdminService adminService;

    private static class RegInfo {
        private String username;
        private String password;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }

    private static class RegReplyMessage {
        private boolean regSuccess;

        public boolean isRegSuccess() {
            return regSuccess;
        }

        public void setRegSuccess(boolean regSuccess) {
            this.regSuccess = regSuccess;
        }
    }

    @CrossOrigin
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public  RegReplyMessage handleRegister(@RequestBody RegInfo regInfo) {
        RegReplyMessage msg = new RegReplyMessage();
        // Set Up User
        User newUser = new User(regInfo.getUsername(), regInfo.getPassword());

        // Set Up User Information

        msg.setRegSuccess(adminService.addUser(newUser));
        return msg;
    }

    //localhost:8080/hasUser?username="SHAOBIN"
    @CrossOrigin
    @RequestMapping("/hasUser")
    public boolean hasUser(@RequestParam(value="username") String username) {
       return adminService.hasUser(username);
    }
}
