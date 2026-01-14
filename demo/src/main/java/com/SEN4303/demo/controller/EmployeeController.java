package com.SEN4303.demo.controller;

import com.SEN4303.demo.model.Employee;
import com.SEN4303.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    // GET all employees
    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    // GET employee by ID
    @GetMapping("/employee/{id}")
    public Employee getEmployeeById(@PathVariable int id) {
        return employeeRepository.findById(id).orElse(null);
    }

    // POST add new employee
    @PostMapping("/employee")
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }

    // PUT update employee
    @PutMapping("/employee/{id}")
    public Employee updateEmployee(
            @PathVariable int id,
            @RequestBody Employee employee) {

        employee.setEmpId(id);
        return employeeRepository.save(employee);
    }

    // DELETE employee
    @DeleteMapping("/employee/{id}")
    public String deleteEmployee(@PathVariable int id) {
        employeeRepository.deleteById(id);
        return "Employee deleted successfully";
    }
}
