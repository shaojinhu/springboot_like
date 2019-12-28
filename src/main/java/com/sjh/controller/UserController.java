package com.sjh.controller;

import com.sjh.pojo.User;
import com.sjh.response.Result;
import com.sjh.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class UserController {


    @Resource
    private UserService userService;


    @PostMapping("login")
    public Result login(@RequestBody User user){
        return userService.login(user);
    }

}
