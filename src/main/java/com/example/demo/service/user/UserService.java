package com.example.demo.service.user;

import com.example.demo.model.User;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class UserService implements IUserService{
    @Override
    public Iterable<User> findAll() {
        return null;
    }

    @Override
    public Optional<User> findOne() {
        return Optional.empty();
    }

    @Override
    public User save(User user) {
        return null;
    }

    @Override
    public void remove(Long id) {

    }
}
