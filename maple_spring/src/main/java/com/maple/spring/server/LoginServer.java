package com.maple.spring.server;


import com.maple.spring.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(maxAge = 3600)
@RestController
public class LoginServer {
    /**
     * Reply message
     */
    public static class LoginReplyMessage {
        private boolean success;
        public boolean isSuccess() {
            return success;
        }
        public void setSuccess(boolean success) {
            this.success = success;
        }
    }

    public static class LoginRequestMessage {
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

    @CrossOrigin
    @RequestMapping(value = "/allEnrollment", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody List<String> getProfile(@RequestParam(value="username") String username) {
        List<String> courses = adminService.getUserCourses(username);
        List<String> res = new ArrayList<>();
        for(String x: courses){
            res.add(x);
            res.add(adminService.getCourseLink(x));
        }
        return res;
    }
}
