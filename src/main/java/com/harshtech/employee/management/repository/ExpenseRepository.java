package com.harshtech.employee.management.repository;

import com.harshtech.employee.management.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository for managing Expense entities.
 * Created on: 2024-12-15
 */
public interface ExpenseRepository extends JpaRepository<Expense, Long> {
}

