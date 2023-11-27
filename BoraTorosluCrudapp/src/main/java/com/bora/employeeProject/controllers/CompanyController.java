package com.bora.employeeProject.controllers;

import com.bora.employeeProject.entities.Company;
import com.bora.employeeProject.entities.Employee;
import com.bora.employeeProject.services.CompanyService;
import com.bora.employeeProject.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    @GetMapping
    private List<Company> findAll(){
        return companyService.findAll();
    }

    @GetMapping("/{id}")
    private Company findById(@PathVariable("id") Long id){
        return companyService.findById(id);
    }

    @PostMapping
    private ResponseEntity<Company> add(@RequestBody Company company){
        return new ResponseEntity<>(companyService.add(company), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    private void deleteById(@PathVariable("id") Long id){
        companyService.deleteById(id);
    }

    @PutMapping("/{id}")
    private Company updateById(Long id ,@RequestBody Company company){
        Company tempCompany = findById(id);
        tempCompany.setCompanyName(company.getCompanyName());
        tempCompany.setAddress(company.getAddress());
        return companyService.updateById(tempCompany);
    }

}
