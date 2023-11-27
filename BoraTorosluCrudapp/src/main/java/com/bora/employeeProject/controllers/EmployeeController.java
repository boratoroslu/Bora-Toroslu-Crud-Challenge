package com.bora.employeeProject.controllers;

import com.bora.employeeProject.entities.Employee;
import com.bora.employeeProject.services.EmployeeService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    private List<Employee> findAll(){
        return employeeService.findAll();
    }

    @GetMapping("/{id}")
    private Employee findById(@PathVariable("id") Long id){
        return employeeService.findById(id);
    }

    @PostMapping
    private ResponseEntity<Employee> add(@RequestBody Employee employee){
        return new ResponseEntity<>(employeeService.add(employee), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    private void deleteById(@PathVariable("id") Long id){
        employeeService.deleteById(id);
    }

    @PutMapping("/{id}")
    private Employee updateById(Long id ,@RequestBody Employee employee){
        Employee tempEmployee = findById(id);
        tempEmployee.setFirstName(employee.getFirstName());
        tempEmployee.setLastName(employee.getLastName());
        tempEmployee.setEmail(employee.getEmail());
        return employeeService.updateById(tempEmployee);
    }

}
