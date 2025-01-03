package com.harshtech.employee.management.repository;

import com.harshtech.employee.management.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Repository for managing Employee entities.
 * Created on: 2024-12-15
 */
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Optional<Employee> findByEmployeeId(String employeeId);

}
