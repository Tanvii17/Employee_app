package com.employeeManagement.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Employee_Table")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer employee_id;
    private String employee_name;
    private String employee_designation;
    private Double employee_salary;
}
