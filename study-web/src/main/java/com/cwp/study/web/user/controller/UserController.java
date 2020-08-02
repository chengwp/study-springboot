package com.cwp.study.web.user.controller;

import com.cwp.study.biz.user.service.UserService;
import com.cwp.study.dao.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService  userService;

    @RequestMapping("/{userId}")
    public User  getUser(@PathVariable("userId") Long userId){
        return userService.getUser(userId);
    }
}
