package com.restApi.demo.restapipractice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restApi.demo.restapipractice.entities.Roles;
import com.restApi.demo.restapipractice.repositories.RolesRepository;

@Service
public class RolesService {
    @Autowired
    private RolesRepository rolesRepository;

    public Roles addRole(Roles entity) {
        return rolesRepository.save(entity);
    }

    public List<Roles> getRoles() {
        var roles = rolesRepository.findAll();
        return roles;
    }

}
