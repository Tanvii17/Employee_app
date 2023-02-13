package com.employeeManagement.controller;

import com.employeeManagement.Exception.ResourceNotFoundException;
import com.employeeManagement.Repository.EmployeeRepository;
import com.employeeManagement.entity.Employee;
import com.employeeManagement.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class EmployeeController {


    @Autowired
    private EmployeeRepository employeeRepository;

    // get all employees
    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
        return (List<Employee>) employeeRepository.findAll();
    }

    // to create employees
    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }

    // get employee by id rest api
    @GetMapping("/employees/{employee_id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Integer employee_id) {
        Employee employee = employeeRepository.findById(employee_id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + employee_id));
        return ResponseEntity.ok(employee);
    }

    // update employee rest api

    @PutMapping("/employees/{employee_id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Integer employee_id, @RequestBody Employee employeeDetails){
        Employee employee = employeeRepository.findById(employee_id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + employee_id));

        employee.setEmployee_name(employeeDetails.getEmployee_name());
        employee.setEmployee_designation(employeeDetails.getEmployee_designation());
        employee.setEmployee_salary(employeeDetails.getEmployee_salary());

        Employee updatedEmployee = employeeRepository.save(employee);
        return ResponseEntity.ok(updatedEmployee);
    }

    // delete employee rest api
    @DeleteMapping("/employees/{employee_id}")
    public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Integer employee_id){
        Employee employee = employeeRepository.findById(employee_id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + employee_id));

        employeeRepository.delete(employee);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
