package com.example.springsecurity.controller;

import java.util.List;
import java.util.Map;

import com.example.springsecurity.model.security.Role;
import com.example.springsecurity.model.security.RoleName;
import com.example.springsecurity.repository.RoleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * RoleController
 */
@RestController
@RequestMapping("/api")
public class RoleController {

    @Autowired
    private RoleRepository roleRepository;

    @GetMapping("/roles")
    public List<Role> getAll() {

        return roleRepository.findAll();
    }

    @DeleteMapping("/roles/{id}")
    public void delete(@PathVariable(value = "id") Long id) {
        roleRepository.deleteById(id);
    }

    @PostMapping("/roles")
    public Role create(@RequestBody Map<String, Object> roleParam) {

        Role role = new Role();
        role.setName(roleParam.get("roleName").toString());

        roleRepository.save(role);
        return role;
    }

}