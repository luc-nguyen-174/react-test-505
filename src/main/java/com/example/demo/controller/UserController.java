package com.example.demo.controller;

import com.example.demo.model.Dto.UserDto;
import com.example.demo.model.Role;
import com.example.demo.model.User;
import com.example.demo.service.user.impl.RoleService;
import com.example.demo.service.user.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    @PostMapping("/signup")
    public ResponseEntity<?> signUp(@RequestBody UserDto userDto) {
        String username = userDto.getUsername();
        String password = userDto.getPassword();
        Optional<User> userOptional = userService.findByUsername(username);
        if (userOptional.isPresent()) {
            return ResponseEntity.badRequest().body("Username already exists");
        }
        Optional<Role> userRole = roleService.findByName("ROLE_USER");
        Optional<Role> clientRole = roleService.findByName("ROLE_CLIENT");
        if (userRole.isEmpty() || clientRole.isEmpty()) {
            return ResponseEntity.badRequest().body("Role not found");
        }
        User user = new User(username, password);
        if (userDto.getRoleName().equals("ROLE_USER")) {
            user.setRoleByRoleId(userRole.get());
        } else if (userDto.getRoleName().equals("ROLE_CLIENT")) {
            user.setRoleByRoleId(clientRole.get());
        } else {
            return ResponseEntity.badRequest().body("Invalid role");
        }
        return new ResponseEntity<>(userService.save(user), HttpStatus.CREATED);
    }


    @GetMapping("/login")
    public ResponseEntity<?> login() {
        return ResponseEntity.ok("User authenticated successfully");
    }
}
