package com.bora.employeeProject.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "companies")
@Data
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "company_name", nullable = false)
    private String companyName;
    @Column(name = "address", nullable = false)
    private String address;

}
