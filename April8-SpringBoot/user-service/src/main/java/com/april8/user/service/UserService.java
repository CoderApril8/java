package com.april8.user.service;

import com.april8.user.pojo.User;

public interface UserService {
    User find(int id);
    void save(int id, String name, int age);
}
