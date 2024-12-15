package com.harshtech.employee.management.repository;

import com.harshtech.employee.management.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    List<Expense> findByEmployeeId(Long employeeId);
    List<Expense> findByStatus(String status);
}

