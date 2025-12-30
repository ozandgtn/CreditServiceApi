package com.banking.creditService.Enums;

import java.math.BigDecimal;

public enum Profession {

	OGRENCI(new BigDecimal("0.0129") , new BigDecimal("100000")),
	MEMUR(new BigDecimal("0.0159") , new BigDecimal("1000000")),
	ASKER(new BigDecimal("0.0179") , new BigDecimal("1500000")),
	CIFTCI(new BigDecimal("0.0149") , new BigDecimal("2000000"));
	
	private final BigDecimal monthlyInterestRate;
	private final BigDecimal maxCreditLimit;
	
	 Profession(BigDecimal monthlyInterestRate, BigDecimal maxCreditLimit) {
	        this.monthlyInterestRate = monthlyInterestRate;
	        this.maxCreditLimit = maxCreditLimit;
	    }

	    public BigDecimal getMonthlyInterestRate() {
	        return monthlyInterestRate;
	    }

	    public BigDecimal getMaxCreditLimit() {
	        return maxCreditLimit;
	    }
	
}
