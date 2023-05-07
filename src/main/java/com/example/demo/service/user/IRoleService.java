package com.example.demo.service.user;

import com.example.demo.model.Role;
import com.example.demo.service.IGeneral;

import java.util.Optional;

public interface IRoleService extends IGeneral<Role> {
    Optional<Role> findByName(String name);
}
