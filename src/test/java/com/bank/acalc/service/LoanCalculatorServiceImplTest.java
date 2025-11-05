package com.bank.acalc.service;

import com.bank.acalc.model.LoanRequest;
import com.bank.acalc.model.LoanResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoanCalculatorServiceImplTest {

    private LoanCalculatorService loanCalculatorService;

    @BeforeEach
    void setUp() {
        loanCalculatorService = new LoanCalculatorServiceImpl();
    }

    @Test
    void calculateLoan_shouldReturnCorrectValues() {
        // Given
        LoanRequest request = new LoanRequest(20000.0, 5, 4.5);
        
        // When
        LoanResponse response = loanCalculatorService.calculateLoan(request);
        
        // Then
        assertNotNull(response);
        assertEquals(372.86, response.getMonthlyPayment(), 0.01);
        assertEquals(22371.62, response.getTotalPayment(), 0.01);
    }

    @Test
    void calculateLoan_withZeroInterest_shouldReturnCorrectValues() {
        // Given
        LoanRequest request = new LoanRequest(20000.0, 5, 0.01);
        
        // When
        LoanResponse response = loanCalculatorService.calculateLoan(request);
        
        // Then
        assertNotNull(response);
        assertEquals(333.42, response.getMonthlyPayment(), 0.01);
        assertEquals(20005.08, response.getTotalPayment(), 0.01);
    }

    @Test
    void calculateLoan_withNullRequest_shouldThrowException() {
        assertThrows(NullPointerException.class, () -> {
            loanCalculatorService.calculateLoan(null);
        });
    }
}
