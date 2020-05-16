package com.april8.user.web;


import com.april8.user.pojo.User;
import com.april8.user.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("user")
public class UserController {
    @Resource
    UserService userService;

    @GetMapping("{id}")
    public User query(@PathVariable("id") Integer id){
        userService.save(id,"april8",25);
        return userService.find(id);
    }

}