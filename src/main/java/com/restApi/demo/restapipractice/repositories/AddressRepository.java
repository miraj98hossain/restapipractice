package com.restApi.demo.restapipractice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restApi.demo.restapipractice.entities.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
