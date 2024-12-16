package com.harshtech.employee.management.repository;

import com.harshtech.employee.management.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
