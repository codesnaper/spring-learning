package com.example.security.service;

import com.example.security.modal.Employee;

import java.util.List;

public interface IEmployeeService {
    List<Employee> userEmployees();

    Employee getUserEmployeeById(long id) throws IllegalAccessException;

    Employee saveEmployee(Employee employee);

    void deleteEmployee(long id);

    Employee editEmployee(Employee employee);

    List<Employee> getEmployee(String name);
}
