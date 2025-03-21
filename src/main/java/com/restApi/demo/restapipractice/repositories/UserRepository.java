package com.restApi.demo.restapipractice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restApi.demo.restapipractice.entities.AppUser;

public interface UserRepository extends JpaRepository<AppUser, Long> {

    AppUser findByUserName(String username);

}
