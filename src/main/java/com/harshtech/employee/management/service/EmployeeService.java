package com.harshtech.employee.management.service;

import com.harshtech.employee.management.exception.DuplicateResourceException;
import com.harshtech.employee.management.exception.ResourceDoesNotExistException;
import com.harshtech.employee.management.model.Employee;
import com.harshtech.employee.management.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


/**
 * Handles business logic for managing Employee.
 * Created on: 2025-01-03
 */
@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    private static final Logger logger = LoggerFactory.getLogger(EmployeeService.class);

    public Employee createEmployeeEntry(Employee employee) throws DuplicateResourceException {
        Optional<Employee> emp = employeeRepository.findByEmployeeId(employee.getEmployeeId());
        if (!emp.isEmpty()) {
            logger.error("Employee with ID {} already exists.", employee.getId());
            throw new DuplicateResourceException("Employee with ID " + employee.getId() + " already exists.");
        }
        return employeeRepository.save(employee);
    }


    public Employee getEmployeeEntry(long employeeId) throws ResourceDoesNotExistException {
        return employeeRepository.findById(employeeId)
                .orElseThrow(() -> {
                    logger.error("Employee with ID {} not found", employeeId);
                    return new ResourceDoesNotExistException("The employee with ID: " + employeeId + " does not exist.");
                });
    }


    public Employee updateEmployeeEntry(Employee employee) throws ResourceDoesNotExistException {
        if (employee.getId() == null) {
            logger.error("Invalid Employee ID: null.");
            throw new ResourceDoesNotExistException("Invalid Employee ID: null.");
        }

        // Fetch the existing employee by ID
        Employee existingEmployee = employeeRepository.findById(employee.getId())
                .orElseThrow(() -> {
                    logger.error("Employee with ID {} not found", employee.getId());
                    return new ResourceDoesNotExistException("The employee with ID: " + employee.getId() + " does not exist.");
                });

        // Update the existing employee's details
        existingEmployee.setName(employee.getName());
        existingEmployee.setEmail(employee.getEmail());
        existingEmployee.setEmployeeId(employee.getEmployeeId());
        return employeeRepository.save(existingEmployee);
    }


    public void deleteEmployeeEntry(long employeeId) throws ResourceDoesNotExistException {
        Employee existingEmployee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> {
                    logger.error("Employee with ID {} not found", employeeId);
                    return new ResourceDoesNotExistException("The employee with ID: " + employeeId + " does not exist.");
                });

        employeeRepository.delete(existingEmployee);
    }
}
