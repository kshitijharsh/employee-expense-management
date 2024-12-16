package com.harshtech.employee.management.repository;

import com.harshtech.employee.management.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
}

