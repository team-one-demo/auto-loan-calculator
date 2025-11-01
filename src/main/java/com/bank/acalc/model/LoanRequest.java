package com.bank.acalc.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

/**
 * Model class representing a loan calculation request.
 */
public class LoanRequest {

    @NotNull(message = "Car price is required")
    @Positive(message = "Car price must be positive")
    private Double carPrice;

    @NotNull(message = "Repayment years is required")
    @Min(value = 1, message = "Repayment years must be at least 1")
    private Integer repaymentYears;

    @NotNull(message = "Interest rate is required")
    @Positive(message = "Interest rate must be positive")
    private Double interestRate;

    // Default constructor
    public LoanRequest() {
    }

    /**
     * Constructor with all fields.
     *
     * @param carPrice the price of the car
     * @param repaymentYears the number of years for repayment
     * @param interestRate the annual interest rate (percentage)
     */
    public LoanRequest(Double carPrice, Integer repaymentYears, Double interestRate) {
        this.carPrice = carPrice;
        this.repaymentYears = repaymentYears;
        this.interestRate = interestRate;
    }

    public Double getCarPrice() {
        return carPrice;
    }

    public void setCarPrice(Double carPrice) {
        this.carPrice = carPrice;
    }

    public Integer getRepaymentYears() {
        return repaymentYears;
    }

    public void setRepaymentYears(Integer repaymentYears) {
        this.repaymentYears = repaymentYears;
    }

    public Double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(Double interestRate) {
        this.interestRate = interestRate;
    }

    @Override
    public String toString() {
        return "LoanRequest{" +
                "carPrice=" + carPrice +
                ", repaymentYears=" + repaymentYears +
                ", interestRate=" + interestRate +
                '}';
    }
}
