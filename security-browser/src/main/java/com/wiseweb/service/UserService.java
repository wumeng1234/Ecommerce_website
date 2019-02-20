package com.wiseweb.service;

import com.wiseweb.entity.User;

import java.util.List;

/**
 * Created by 吴猛
 * Date：2019/2/20
 */
public interface UserService {
    List<User> getUsers();
    void addUser(User user);
}
