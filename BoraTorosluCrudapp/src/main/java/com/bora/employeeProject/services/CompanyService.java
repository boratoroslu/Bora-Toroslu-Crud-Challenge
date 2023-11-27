package com.bora.employeeProject.services;

import com.bora.employeeProject.entities.Company;
import com.bora.employeeProject.entities.Employee;
import com.bora.employeeProject.repos.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {
    @Autowired
    private CompanyRepository companyRepository;

    public List<Company> findAll(){
        return companyRepository.findAll();
    }

    public Company findById(Long id){
        return companyRepository.findById(id).get();
    }

    public Company add(Company company){
        return companyRepository.save(company);
    }

    public void deleteById(Long id){
        companyRepository.deleteById(id);
    }

    public Company updateById(Company company){
        return companyRepository.save(company);
    }
}
