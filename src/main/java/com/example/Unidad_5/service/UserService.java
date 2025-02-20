package com.example.Unidad_5.service;

import com.example.Unidad_5.model.Roles;
import com.example.Unidad_5.model.User;
import com.example.Unidad_5.respository.RolesRepository;
import com.example.Unidad_5.respository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RolesRepository rolesRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }
    public User createUser(User user){
        return userRepository.save(user);
    }
    public  User updateUser(Long id, User userDetails){
    Optional<User> userOpt = userRepository.findById(id);
    if (userOpt.isPresent()){
        User user = userOpt.get();
        user.setName(userDetails.getName());
        user.setEmail(userDetails.getEmail());
        user.setRoles(userDetails.getRoles());
        return userRepository.save(user);
    }
    return null;
    }
    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }

    public User assignRoleUser(Long userId, Long roleId) {
        Optional<User> userOpt = userRepository.findById(userId);
        Optional<Roles> roleOpt = rolesRepository.findById(roleId);

        if (userOpt.isPresent() && roleOpt.isPresent()) {
            User user = userOpt.get();
            Roles role = roleOpt.get();

            if (user.getRoles() == null) {
                user.setRoles(new HashSet<>());
            }

            user.getRoles().add(role);
            return userRepository.save(user);
        }
        return null;
    }
}



