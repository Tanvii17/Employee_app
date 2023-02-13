package com.employeeManagement.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer employee_id;
    private String employee_name;
    private String employee_designation;
    private Double employee_salary;

    public Employee() {
    }

    public Employee(Integer employee_id, String employee_name, String employee_designation, Double employee_salary) {
        this.employee_id = employee_id;
        this.employee_name = employee_name;
        this.employee_designation = employee_designation;
        this.employee_salary = employee_salary;
    }

    public Integer getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(Integer employee_id) {
        this.employee_id = employee_id;
    }

    public String getEmployee_name() {
        return employee_name;
    }

    public void setEmployee_name(String employee_name) {
        this.employee_name = employee_name;
    }

    public String getEmployee_designation() {
        return employee_designation;
    }

    public void setEmployee_designation(String employee_designation) {
        this.employee_designation = employee_designation;
    }

    public Double getEmployee_salary() {
        return employee_salary;
    }

    public void setEmployee_salary(Double employee_salary) {
        this.employee_salary = employee_salary;
    }
}
