package com.harshtech.employee.management.service;

import com.harshtech.employee.management.repository.EmployeeRepository;
import com.harshtech.employee.management.repository.ExpenseRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

public class ExpenseServiceTest {

    @Mock
    private ExpenseRepository expenseRepository;

    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private ExpenseService expenseService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSubmitExpense() {
    }
}
