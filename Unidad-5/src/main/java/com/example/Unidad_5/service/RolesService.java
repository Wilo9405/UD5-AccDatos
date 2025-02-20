package com.example.Unidad_5.service;

import com.example.Unidad_5.model.Roles;
import com.example.Unidad_5.respository.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolesService {
    @Autowired
    private RolesRepository rolesRepository;

    public List<Roles> getAllRoles() {
        return rolesRepository.findAll();
    }
    public Roles createRole(Roles role){
        return rolesRepository.save(role);
    }

}
