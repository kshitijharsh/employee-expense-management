package com.harshtech.employee.management.service;

import com.harshtech.employee.management.model.Employee;
import com.harshtech.employee.management.model.Expense;
import com.harshtech.employee.management.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Handles business logic for managing Employee.
 * Created on: 2025-01-03
 */
@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;


    public Employee createEmployeeEntry(Employee employee) {
        return employeeRepository.save(employee);
    }
}
