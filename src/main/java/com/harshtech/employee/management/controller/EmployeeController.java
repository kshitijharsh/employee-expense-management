package com.harshtech.employee.management.controller;

import com.harshtech.employee.management.model.Employee;
import com.harshtech.employee.management.model.Expense;
import com.harshtech.employee.management.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * REST Controller for managing Employee.
 * Created on: 2025-01-03
 */
@RestController
@RequestMapping("/api/employee")
public class EmployeeController {


    @Autowired
    private EmployeeService employeeService;

    /**
     * Add a new employee in the organisation.
     * Created on: 2025-01-03
     */
    @PostMapping()
    public Employee postEmployee(@RequestBody Employee employee) {
        return employeeService.createEmployeeEntry(employee);
    }

    @DeleteMapping("/{employee_id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("employee_id") long employeeId) {
        return employeeService.deleteEmployeeEntry(employeeId);
    }

}
