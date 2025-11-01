package com.bank.acalc.service;

import com.bank.acalc.model.LoanRequest;
import com.bank.acalc.model.LoanResponse;

/**
 * Service interface for loan calculations.
 */
public interface LoanCalculatorService {

    /**
     * Calculates loan details based on the provided request.
     *
     * @param request the loan calculation request
     * @return the loan calculation response with monthly and total payments
     */
    LoanResponse calculateLoan(LoanRequest request);
}
