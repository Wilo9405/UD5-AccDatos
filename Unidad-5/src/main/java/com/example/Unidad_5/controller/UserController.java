package com.example.Unidad_5.controller;
import java.util.List;
import java.util.Optional;

import com.example.Unidad_5.model.User;
import com.example.Unidad_5.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
    @GetMapping("/{id}")
    public Optional<User>getUserById(@PathVariable Long id){
        return userService.getUserById(id);
    }
    @PostMapping
    public User createUser(@RequestBody User user){
        return userService.createUser(user);
    }
    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user){
        return userService.updateUser(id, user);
    }
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
    }
    @PostMapping("/{userId}/roles/{roleId}")
    public User assignRoleUser(@PathVariable Long userId, @PathVariable Long roleId){
        return userService.assignRoleUser(userId, roleId);
    }
}
