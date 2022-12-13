package com.employeeManagement.service;

import com.employeeManagement.entity.Employee;


import java.util.List;

public interface EmployeeService {
    public String addEmployee(Employee employee);

    public List<Employee> getAllEmployees();

    public Employee getEmployeeById(Integer employee_id);


    public String updateEmployeeById(Integer employee_id);

    public String deleteEmployeeById(Integer employee_id);
}
