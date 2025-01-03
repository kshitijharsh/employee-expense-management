package com.harshtech.employee.management.service;

import com.harshtech.employee.management.model.Employee;
import com.harshtech.employee.management.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional
    public ResponseEntity<?> deleteEmployeeEntry(long employeeId) {
        if(employeeRepository.findById(employeeId).isEmpty()){
            return ResponseEntity.notFound().build();  // HTTP 404 if the employee is not found
        }
        employeeRepository.deleteById(employeeId);
        return ResponseEntity.noContent().build();
    }
}
