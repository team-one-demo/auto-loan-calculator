package com.bank.acalc.model;

/**
 * Model class representing a loan calculation response.
 */
public class LoanResponse {

    private Double monthlyPayment;
    private Double totalPayment;

    // Default constructor
    public LoanResponse() {
    }

    /**
     * Constructor with all fields.
     *
     * @param monthlyPayment the calculated monthly payment
     * @param totalPayment the total amount paid over the life of the loan
     */
    public LoanResponse(Double monthlyPayment, Double totalPayment) {
        this.monthlyPayment = monthlyPayment;
        this.totalPayment = totalPayment;
    }

    public Double getMonthlyPayment() {
        return monthlyPayment;
    }

    public void setMonthlyPayment(Double monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }

    public Double getTotalPayment() {
        return totalPayment;
    }

    public void setTotalPayment(Double totalPayment) {
        this.totalPayment = totalPayment;
    }

    @Override
    public String toString() {
        return "LoanResponse{" +
                "monthlyPayment=" + monthlyPayment +
                ", totalPayment=" + totalPayment +
                '}';
    }
}
