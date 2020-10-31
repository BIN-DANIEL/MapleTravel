package com.maple.spring.server;


import com.maple.spring.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
public class LoginServer {
    /**
     * Reply message
     */
    static class LoginReplyMessage {
        private boolean success;
        public boolean isSuccess() {
            return success;
        }
        public void setSuccess(boolean success) {
            this.success = success;
        }
    }
    static class LoginRequestMessage {
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
    @Autowired
    AdminService adminService;

    @CrossOrigin
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public LoginReplyMessage handleLogin(@RequestBody LoginRequestMessage request) {

        LoginReplyMessage msg = new LoginReplyMessage();

            if (adminService.getUser(request.getUsername()).getPassword().equals(request.getPassword())) {
                msg.setSuccess(true);
            } else {
                msg.setSuccess(false);
            }
        return msg;
    }

}
