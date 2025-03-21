package com.restApi.demo.restapipractice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restApi.demo.restapipractice.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
