package com.restApi.demo.restapipractice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restApi.demo.restapipractice.entities.Employee;
import com.restApi.demo.restapipractice.services.EmployeeService;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/api/emp")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/createEmp")
    public ResponseEntity<Employee> createEmployee(@RequestBody String employeeJson) {
        Employee emp = new Employee();
        emp = employeeService.createEmployee(employeeJson);
        return ResponseEntity.ok().body(emp);
    }

    @GetMapping("/getEmp/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable("id") Long id) {
        Employee emp = new Employee();
        emp = employeeService.getEmployee(id);
        return ResponseEntity.ok().body(emp);
    }

    @GetMapping("/getAllEmp")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> emplist;
        emplist = employeeService.getAllEmployee();
        return ResponseEntity.ok().body(emplist);
    }

    @DeleteMapping("/removeEmp/{id}")
    public ResponseEntity<String> removeEmployee(@PathVariable("id") Long id) {

        employeeService.removeEmployee(id);
        return ResponseEntity.ok().body("Employee removed successfully");
    }

}
