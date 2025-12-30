package com.banking.creditService.Entities;

import java.math.BigDecimal;

import com.banking.creditService.Enums.Profession;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="loanCalculations")
public class LoanCalculation {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY) 
     private int id ;
     @Enumerated(EnumType.STRING)
     @Column(name = "profession", nullable = false)
     private Profession profession;
     @Column(name = "requestedAmount")
     private int requestedAmount;    // İSTENEN KREDİ MİKTARI
     @Column(name = "termMonths")
     private int termMonths;       // VADE (AY)
     @Column(name = "monthlyInterestRate")
     private BigDecimal monthlyInterestRate;       // UYGULANAN FAİZ
     @Column(name = "totalPayment")
     private BigDecimal totalPayment;    // TOPLAM GERİ ÖDEME
     @Column(name = "monthlyInstallment")
     private BigDecimal monthlyInstallment;  // AYLIK TAKSİT
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
