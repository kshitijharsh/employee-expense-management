package com.harshtech.employee.management.controller;

import com.harshtech.employee.management.model.Expense;
import com.harshtech.employee.management.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    @PostMapping("/{employeeId}")
    public Expense submitExpense(@PathVariable Long employeeId, @RequestBody Expense expense) {
        return expenseService.submitExpense(employeeId, expense);
    }

    @PutMapping("/approve/{expenseId}")
    public Expense approveExpense(@PathVariable Long expenseId) {
        return expenseService.approveExpense(expenseId);
    }

    @PutMapping("/reject/{expenseId}")
    public Expense rejectExpense(@PathVariable Long expenseId, @RequestParam String feedback) {
        return expenseService.rejectExpense(expenseId, feedback);
    }
}
