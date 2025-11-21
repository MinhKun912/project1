package com.example.jobportal.service;

import com.example.jobportal.entity.User;

public interface UserService {
    User save(User user);
    User findByUsername(String username);
}
