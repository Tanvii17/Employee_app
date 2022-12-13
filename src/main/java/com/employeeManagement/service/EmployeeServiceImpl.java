package com.employeeManagement.service;

import com.employeeManagement.Repository.EmployeeRepository;
import com.employeeManagement.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository repository;


    @Override
    public String addEmployee(Employee employee) {
         repository.save(employee).getEmployee_id();
         return "";
    }

    @Override
    public List<Employee> getAllEmployees() {

        return (List<Employee>) repository.findAll();
    }

    @Override
    public Employee getEmployeeById(Integer employee_id) {

        return repository.findById(employee_id).get();
    }

    @Override
    public String updateEmployeeById(Integer employee_id) {


        return "Employee record Updated for id - "+employee_id;
    }


    @Override
    public String deleteEmployeeById(Integer employee_id) {

        repository.deleteById(employee_id);
        return "Employee record deleted  id - "+employee_id;
    }




}
