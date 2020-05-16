package com.april8.user.service.impl;

import com.april8.user.mapper.UserMapper;
import com.april8.user.pojo.User;
import com.april8.user.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public User find(int id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public void save(int id, String name, int age) {
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setAge(age);
        userMapper.updateByPrimaryKeySelective(user);

    }
}
