package com.example.demo.service.user;

import com.example.demo.model.User;
import com.example.demo.service.IGeneral;

import java.util.Optional;

public interface IUserService extends IGeneral<User> {
    Optional<User> findByUsername(String username);
}
