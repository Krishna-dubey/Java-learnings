package com.example.cruddemo.service;

import com.example.cruddemo.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    List<Employee> findAll();

    Employee findById(int theId);
    Employee save(Employee employee);

    void deleteById(int theId);


}
