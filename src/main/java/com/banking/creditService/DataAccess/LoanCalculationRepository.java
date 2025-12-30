package com.banking.creditService.DataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import com.banking.creditService.Entities.LoanCalculation;

public interface LoanCalculationRepository extends JpaRepository<LoanCalculation, Integer> {
}
