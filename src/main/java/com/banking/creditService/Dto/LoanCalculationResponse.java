package com.banking.creditService.Dto;

import java.math.BigDecimal;

import com.banking.creditService.Enums.Profession;

public class LoanCalculationResponse {

    private int id;
    private Profession profession;
    private int requestedAmount;
    private int termMonths;
    private BigDecimal monthlyInterestRate;
    private BigDecimal totalPayment;
    private BigDecimal monthlyInstallment;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Profession getProfession() {
        return profession;
    }

    public void setProfession(Profession profession) {
        this.profession = profession;
    }

    public int getRequestedAmount() {
        return requestedAmount;
    }

    public void setRequestedAmount(int requestedAmount) {
        this.requestedAmount = requestedAmount;
    }

    public int getTermMonths() {
        return termMonths;
    }

    public void setTermMonths(int termMonths) {
        this.termMonths = termMonths;
    }

    public BigDecimal getMonthlyInterestRate() {
        return monthlyInterestRate;
    }

    public void setMonthlyInterestRate(BigDecimal monthlyInterestRate) {
        this.monthlyInterestRate = monthlyInterestRate;
    }

    public BigDecimal getTotalPayment() {
        return totalPayment;
    }

    public void setTotalPayment(BigDecimal totalPayment) {
        this.totalPayment = totalPayment;
    }

    public BigDecimal getMonthlyInstallment() {
        return monthlyInstallment;
    }

    public void setMonthlyInstallment(BigDecimal monthlyInstallment) {
        this.monthlyInstallment = monthlyInstallment;
    }
}
