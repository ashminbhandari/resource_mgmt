package com.itlize.resrcmgmt.controller;

import com.itlize.resrcmgmt.entity.User;
import com.itlize.resrcmgmt.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;
    
    @GetMapping("/profile")
    public ResponseEntity<?> getUserProfile() {
        User u = userService.getCurUserInfo();
        u.setPassword("");
        return ResponseEntity.ok(u);
    }

    @GetMapping("/change")
    public ResponseEntity<?> changePassword() {

        return ResponseEntity.ok("Successfully updated"); 
    }

    @GetMapping("/inactivate")
    public ResponseEntity<?> inActivateAccount() {

        return ResponseEntity.ok("Successfully inactivate"); 
    }
}
