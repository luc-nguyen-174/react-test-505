package com.example.demo.service.user.impl;

import com.example.demo.model.Role;
import com.example.demo.repo.IRoleRepository;
import com.example.demo.service.user.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class RoleService implements IRoleService {
    @Autowired
    private IRoleRepository roleRepository;
    @Override
    public Iterable<Role> findAll() {
        return null;
    }

    @Override
    public Optional<Role> findOne(Long id) {
        return Optional.empty();
    }

    @Override
    public Role save(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public void remove(Long id) {
            roleRepository.deleteById(id);
    }

    @Override
    public Optional<Role> findByName(String name) {
        return roleRepository.findByName(name);
    }
}
