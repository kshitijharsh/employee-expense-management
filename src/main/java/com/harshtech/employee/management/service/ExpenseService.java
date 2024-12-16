package com.harshtech.employee.management.service;


import com.harshtech.employee.management.model.Expense;
import com.harshtech.employee.management.repository.EmployeeRepository;
import com.harshtech.employee.management.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

/**
 * Handles business logic for managing expenses.
 * Created on: 2024-12-15
 */
@Service
public class ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    public Expense submitExpense(Long employeeId, Expense expense) {
    //    expense.setEmployee(employeeRepository.findById(employeeId).orElseThrow(() -> new RuntimeException("Employee not found")));
        expense.setDateSubmitted(LocalDate.now());
        return expenseRepository.save(expense);
    }

    public Expense approveExpense(Long expenseId) {
        Expense expense = expenseRepository.findById(expenseId).orElseThrow(() -> new RuntimeException("Expense not found"));
        expense.setStatus("APPROVED");
        expense.setDateApproved(LocalDate.now());
        return expenseRepository.save(expense);
    }

    public Expense rejectExpense(Long expenseId, String reason) {
        Expense expense = expenseRepository.findById(expenseId).orElseThrow(() -> new RuntimeException("Expense not found"));
        expense.setStatus("REJECTED");
        expense.setRejectionReason(reason);
        return expenseRepository.save(expense);
    }
}
