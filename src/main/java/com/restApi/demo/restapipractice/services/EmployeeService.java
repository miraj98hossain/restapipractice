package com.restApi.demo.restapipractice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.restApi.demo.restapipractice.entities.Employee;
import com.restApi.demo.restapipractice.repositories.EmployeeRepository;
import com.restApi.demo.restapipractice.repositories.RolesRepository;
import com.restApi.demo.restapipractice.utils.EntityObjectMapper;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private RolesRepository rolesRepository;
    EntityObjectMapper entityObjectMapper = new EntityObjectMapper();

    public Employee createEmployee(Employee employee) {
        var role = rolesRepository.findById(employee.getRole().getRoleid()).orElseThrow();
        Employee emp = new Employee();
        employee.setRole(role);
        emp = employeeRepository.save(employee);
        return emp;
    }

    public Employee getEmployee(long id) {
        Employee emp = new Employee();
        emp = employeeRepository.findById(id).orElseThrow();
        return emp;
    }

    public List<Employee> getAllEmployee() {
        List<Employee> empList = employeeRepository.findAll();
        return empList;
    }

    public void removeEmployee(Long id) {
        employeeRepository.findById(id).orElseThrow();
        employeeRepository.deleteById(id);
    }
}
