package com.bank.acalc.controller;

import com.bank.acalc.model.LoanRequest;
import com.bank.acalc.model.LoanResponse;
import com.bank.acalc.service.LoanCalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.validation.Valid;

/**
 * REST controller for auto loan calculations.
 */
@RestController
@RequestMapping("/api/loan")
@CrossOrigin(origins = "*", maxAge = 3600)
public class LoanCalculatorController {

    private final LoanCalculatorService loanCalculatorService;

    /**
     * Constructor for dependency injection.
     *
     * @param loanCalculatorService the loan calculator service
     */
    @Autowired
    public LoanCalculatorController(LoanCalculatorService loanCalculatorService) {
        this.loanCalculatorService = loanCalculatorService;
    }

    /**
     * Endpoint for calculating loan details.
     *
     * @param request the loan calculation request
     * @return the loan calculation response
     */
    @PostMapping("/calculate")
    public ResponseEntity<LoanResponse> calculateLoan(@Valid @RequestBody LoanRequest request) {
        LoanResponse response = loanCalculatorService.calculateLoan(request);
        return ResponseEntity.ok(response);
    }

    @RequestMapping(value = "/api/updateUserProfile")
    public void updateUserProfile(String email) {
        // Process profile update
        System.out.println("Profile updated for: " + email);
    }
}
