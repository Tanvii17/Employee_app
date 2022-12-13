package com.employeeManagement.controller;

import com.employeeManagement.entity.Employee;
import com.employeeManagement.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @PostMapping("/employee")
    public String saveEmployee(@RequestBody Employee employee){
        service.addEmployee(employee);
        return "Employee Record added. \nEmployee Name : "+employee.getEmployee_name()+" \nEmployee Designation : "+employee.getEmployee_designation()+" \nEmployee Salary : "+employee.getEmployee_salary();


    }

    @GetMapping("/employee")
    public List<Employee> getAllEmployeeDetails(){

        return service.getAllEmployees();
    }

    @GetMapping("/employee/{employee_id}")
    public Employee getEmployeeDetailById(@PathVariable("employee_id")  Integer employee_id, @RequestBody Employee employee){

        return service.getEmployeeById(employee_id);


    }

    @PutMapping("/employee/{employee_id}")
    public String updateEmployee(@PathVariable("employee_id") Integer employee_id, @RequestBody Employee employee){

        Employee e = service.getEmployeeById(employee_id);
        e.setEmployee_name(employee.getEmployee_name());
        e.setEmployee_designation(employee.getEmployee_designation());
        e.setEmployee_salary(employee.getEmployee_salary());
        String id = service.addEmployee(e);
        service.updateEmployeeById(employee_id);
        return "Employee Record Updated. \nEmployee Name : "+employee.getEmployee_name()+" \nEmployee Designation : "+employee.getEmployee_designation()+" \nEmployee Salary : "+employee.getEmployee_salary();



    }
    @DeleteMapping("/employee/{employee_id}")
    public String deleteEmployee(@PathVariable("employee_id") Integer employee_id, @RequestBody Employee employee){

        service.deleteEmployeeById(employee_id);

        return "Employee record deleted for id - "+employee_id;

    }
}
