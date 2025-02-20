package com.example.Unidad_5.controller;

import com.example.Unidad_5.model.Roles;
import com.example.Unidad_5.service.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roles")
public class RolesController {
    @Autowired
    private RolesService rolesService;

    @GetMapping
    public List<Roles> getAllRoles() {
        return rolesService.getAllRoles();
    }
    @PostMapping
    public Roles createRole(@RequestBody Roles role){
        return rolesService.createRole(role);
    }
}
