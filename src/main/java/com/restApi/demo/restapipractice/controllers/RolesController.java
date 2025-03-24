package com.restApi.demo.restapipractice.controllers;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.restApi.demo.restapipractice.entities.Roles;
import com.restApi.demo.restapipractice.services.RolesService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api/roles/")
public class RolesController {
    @Autowired
    private RolesService rolesService;

    @PostMapping("addRole")
    public ResponseEntity<Roles> addRole(@RequestBody Roles entity) {

        var savedRole = rolesService.addRole(entity);
        return ResponseEntity.ok().body(savedRole);
    }

    @GetMapping("getAllRoles")
    public ResponseEntity<List<Roles>> getRoles() {
        var roles = rolesService.getRoles();
        return ResponseEntity.ok().body(roles);
    }

}
