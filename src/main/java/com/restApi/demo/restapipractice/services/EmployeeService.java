package com.restApi.demo.restapipractice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.restApi.demo.restapipractice.entities.Employee;
import com.restApi.demo.restapipractice.repositories.EmployeeRepository;
import com.restApi.demo.restapipractice.utils.EntityObjectMapper;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    EntityObjectMapper entityObjectMapper = new EntityObjectMapper();

    public Employee createEmployee(String employeeJson) {

        Employee emp = new Employee();
        emp = entityObjectMapper.objectMapperReadValue(employeeJson, Employee.class);
        emp = employeeRepository.save(emp);
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
