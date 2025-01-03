package com.harshtech.employee.management.service;


import com.harshtech.employee.management.model.Employee;
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

    public Expense submitExpense(Expense expense) {
        // Fetch the employee from the database using the provided employee ID
        Employee employee = employeeRepository.findById(expense.getEmployee().getId()).orElse(null);

        // If employee exists, set it in the expense
        if (employee != null) {
            expense.setEmployee(employee);
        } else {
            // Handle the case where the employee is not found (e.g., throw an exception or return a specific response)
            // For now, we will return a null response as a fallback
            return null;
        }

        // Save the expense and return it
        return expenseRepository.save(expense);
    }

    public Expense approveExpense(Long expenseId) {
        Expense expense = expenseRepository.findById(expenseId).orElseThrow(() -> new RuntimeException("Expense not found"));
        expense.setDateApproved(LocalDate.now());
        return expenseRepository.save(expense);
    }

    public Expense rejectExpense(Long expenseId, String reason) {
        Expense expense = expenseRepository.findById(expenseId).orElseThrow(() -> new RuntimeException("Expense not found"));
        expense.setRejectionReason(reason);
        return expenseRepository.save(expense);
    }
}
