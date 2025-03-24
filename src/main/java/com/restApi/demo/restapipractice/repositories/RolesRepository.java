package com.restApi.demo.restapipractice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restApi.demo.restapipractice.entities.Roles;

public interface RolesRepository extends JpaRepository<Roles, Long> {

}
