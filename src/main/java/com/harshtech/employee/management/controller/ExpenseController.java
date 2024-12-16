package com.harshtech.employee.management.controller;

import com.harshtech.employee.management.model.Expense;
import com.harshtech.employee.management.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * REST Controller for managing expenses.
 * Created on: 2024-12-15
 */
@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    /**
     * Submits a new expense for an employee.
     * Created on: 2024-12-15
     */
    @PostMapping("/{employeeId}")
    public Expense submitExpense(@PathVariable Long employeeId, @RequestBody Expense expense) {
        return expenseService.submitExpense(employeeId, expense);
    }

    /**
     * Approves an expense.
     * Created on: 2024-12-15
     */
    @PutMapping("/approve/{expenseId}")
    public Expense approveExpense(@PathVariable Long expenseId) {
        return expenseService.approveExpense(expenseId);
    }

    /**
     * Rejects an expense with a reason.
     * Created on: 2024-12-15
     */
    @PutMapping("/reject/{expenseId}")
    public Expense rejectExpense(@PathVariable Long expenseId, @RequestParam String feedback) {
        return expenseService.rejectExpense(expenseId, feedback);
    }
}
