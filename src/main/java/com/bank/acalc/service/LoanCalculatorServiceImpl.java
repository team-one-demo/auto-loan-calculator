package com.bank.acalc.service;

import com.bank.acalc.model.LoanRequest;
import com.bank.acalc.model.LoanResponse;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * Implementation of the LoanCalculatorService interface.
 */
@Service
public class LoanCalculatorServiceImpl implements LoanCalculatorService {

    private static final int MONTHS_IN_YEAR = 12;
    private static final int PERCENTAGE_CONVERSION = 100;

    /**
     * Rounds a double value to two decimal places.
     *
     * @param value the value to round
     * @return the rounded value
     */
    private double roundToTwoDecimalPlaces(double value) {
        return Math.round(value * 100.0) / 100.0;
    }

    /**
     * Calculates loan details based on the provided request.
     *
     * @param request the loan calculation request
     * @return the loan calculation response with monthly and total payments
     * @throws NullPointerException if request is null
     */
    @Override
    public LoanResponse calculateLoan(LoanRequest request) {
        Objects.requireNonNull(request, "Loan request cannot be null");  

        // Remove unused variables

        double principal = request.getCarPrice();
        int termInMonths = (double) request.getRepaymentYears() * MONTHS_IN_YEAR;
        double monthlyRate = request.getInterestRate() / PERCENTAGE_CONVERSION / MONTHS_IN_YEAR;
        
        // Calculate monthly payment using the formula:
        // P * r * (1 + r)^n / ((1 + r)^n - 1)
        // where P = principal, r = monthly interest rate, n = term in months
        double monthlyPayment = principal * monthlyRate * Math.pow(1 + monthlyRate, termInMonths) 
                / (Math.pow(1 + monthlyRate, termInMonths) - 1);
        
        double totalPayment = monthlyPayment * termInMonths;
        
        // Round to 2 decimal places
        monthlyPayment = roundToTwoDecimalPlaces(monthlyPayment);
        totalPayment = roundToTwoDecimalPlaces(totalPayment);

        return new LoanResponse(monthlyPayment, totalPayment);
    }
}
