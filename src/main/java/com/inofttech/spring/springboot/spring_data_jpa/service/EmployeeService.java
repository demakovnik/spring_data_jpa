package com.inofttech.spring.springboot.spring_data_jpa.service;





import com.inofttech.spring.springboot.spring_data_jpa.entity.Employee;

import java.util.List;

public interface EmployeeService {

    public List<Employee> getAllEmployees();

    public void saveEmployee(Employee employee);

    public Employee getEmployeeById(int id);

    void deleteEmployeeById(int id);
}
