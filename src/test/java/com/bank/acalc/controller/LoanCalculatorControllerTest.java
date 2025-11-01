package com.bank.acalc.controller;

import com.bank.acalc.model.LoanRequest;
import com.bank.acalc.model.LoanResponse;
import com.bank.acalc.service.LoanCalculatorService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(LoanCalculatorController.class)
class LoanCalculatorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private LoanCalculatorService loanCalculatorService;

    @Test
    void calculateLoan_shouldReturnLoanResponse() throws Exception {
        // Given
        LoanResponse mockResponse = new LoanResponse(372.86, 22371.6);
        when(loanCalculatorService.calculateLoan(any(LoanRequest.class))).thenReturn(mockResponse);

        // When/Then
        mockMvc.perform(post("/api/loan/calculate")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"carPrice\": 20000.0, \"repaymentYears\": 5, \"interestRate\": 4.5}")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.monthlyPayment").value(372.86))
                .andExpect(jsonPath("$.totalPayment").value(22371.6));
    }

    @Test
    void calculateLoan_withInvalidRequest_shouldReturnBadRequest() throws Exception {
        // When/Then
        mockMvc.perform(post("/api/loan/calculate")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"carPrice\": -20000.0, \"repaymentYears\": 5, \"interestRate\": 4.5}")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }
}