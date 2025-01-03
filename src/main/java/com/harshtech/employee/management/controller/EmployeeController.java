package com.harshtech.employee.management.controller;

import com.harshtech.employee.management.exception.DuplicateResourceException;
import com.harshtech.employee.management.exception.ResourceDoesNotExistException;
import com.harshtech.employee.management.model.Employee;
import com.harshtech.employee.management.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;

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
     * This method validates the incoming employee object and creates a new employee entry.
     * If the employee ID already exists in the system, it catches the DuplicateResourceException
     *
     * @param employee The employee object provided in the request body, validated using annotations.
     * @return A ResponseEntity containing:
     *         - The created employee object with a 201 Created status if successful.
     *         - An error message with a 409 Conflict status if the employee already exists.
     */
    @PostMapping()
    public ResponseEntity<?> postEmployee(@RequestBody @Validated Employee employee) {
        try{
            Employee createdEmployee = employeeService.createEmployeeEntry(employee);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdEmployee);
        } catch(DuplicateResourceException duplicateResourceException){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(duplicateResourceException.getMessage());
        }
    }

    /**
     * This method attempts to find an employee using the provided employee ID.
     * If no employee is found, it returns an empty Optional.
     *
     * @param employeeId The ID of the employee to retrieve.
     * @return ResponseEntity with the employee object or an error message.
     */
    @GetMapping("/{employee_id}")
    public ResponseEntity<?> getEmployee(@PathVariable("employee_id") long employeeId) {
        try{
            Employee createdEmployee = employeeService.getEmployeeEntry(employeeId);
            return ResponseEntity.status(HttpStatus.OK).body(createdEmployee);
        } catch(ResourceDoesNotExistException resourceDoesNotExistException){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(resourceDoesNotExistException.getMessage());
        }
    }

    /**
     * This method updates the employee's information with the provided details. If the employee does not exist,
     * it returns a not found response.
     *
     * @param employee The employee object containing the updated information.
     * @return A ResponseEntity indicating the result of the update operation.
     */
    @PutMapping()
    public ResponseEntity<?> updateEmployee(@RequestBody @Validated Employee employee) {
        try{
            Employee employeeUpdated = employeeService.updateEmployeeEntry(employee);
            return ResponseEntity.status(HttpStatus.OK).body(employeeUpdated);
        } catch(ResourceDoesNotExistException resourceDoesNotExistException){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(resourceDoesNotExistException.getMessage());
        }
    }

    /**
     * This method handles HTTP DELETE requests to the "/{employee_id}" endpoint.
     * It takes an employee ID as a path variable and calls the service layer to
     * delete the corresponding employee record.
     *
     * @param employeeId The ID of the employee to be deleted.
     * @return A ResponseEntity indicating the result of the deletion operation.
     */
    @DeleteMapping("/{employee_id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("employee_id") long employeeId) {
        try{
            employeeService.deleteEmployeeEntry(employeeId);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch(ResourceDoesNotExistException resourceDoesNotExistException){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(resourceDoesNotExistException.getMessage());
        }
    }

}
