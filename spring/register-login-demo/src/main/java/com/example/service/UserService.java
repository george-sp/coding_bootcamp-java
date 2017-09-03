package com.example.service;

import com.example.model.User;

public interface UserService {

    void save(User user);

    User findByUsername(String username);
}
