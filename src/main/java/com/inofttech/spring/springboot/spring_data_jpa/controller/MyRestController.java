package com.inofttech.spring.springboot.spring_data_jpa.controller;


import com.inofttech.spring.springboot.spring_data_jpa.entity.Employee;
import com.inofttech.spring.springboot.spring_data_jpa.exception_handling.NoSuchEmployeeException;
import com.inofttech.spring.springboot.spring_data_jpa.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyRestController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> showAllEmployees() {
        List<Employee> allEmployees = employeeService.getAllEmployees();
        return allEmployees;
    }

    @GetMapping("/employees/name/{name}")
    public List<Employee> showAllEmployeesByName(@PathVariable String name) {
        List<Employee> allEmployeesByName = employeeService.getAllByName(name);
        return allEmployeesByName;
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable int id) {
        Employee employee = employeeService.getEmployeeById(id);

        if (employee == null) {
            throw new NoSuchEmployeeException("There is no employee with ID=" + id
                    + " in database");
        }
        return employee;
    }

    @PostMapping("/employees")
    public Employee addNewEmployee(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
        return employee;

    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
        return employee;
    }

   @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable int id) {
        Employee employee = employeeService.getEmployeeById(id);
        if(employee==null) {
            throw new NoSuchEmployeeException("There is no Employee with ID= " + id + " in database");
        }
        employeeService.deleteEmployeeById(id);
        return "Employee with ID= " + id + " was deleted";
    }

}
