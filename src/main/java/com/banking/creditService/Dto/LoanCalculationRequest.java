package com.banking.creditService.Dto;

import com.banking.creditService.Enums.Profession;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class LoanCalculationRequest {

    @NotNull
    private Profession profession;

    @Min(1)
    private int requestedAmount;

    @Min(1)
    private int termMonths;

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
}
