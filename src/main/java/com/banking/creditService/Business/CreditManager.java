package com.banking.creditService.Business;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.banking.creditService.Dto.LoanCalculationRequest;
import com.banking.creditService.Dto.LoanCalculationResponse;
import com.banking.creditService.Entities.LoanCalculation;
import com.banking.creditService.Enums.Profession;
import com.banking.creditService.Exception.LimitExceededException;
import com.banking.creditService.DataAccess.LoanCalculationRepository;

@Service
public class CreditManager implements ICreditService {

    private final LoanCalculationRepository loanCalculationRepository;

    public CreditManager(LoanCalculationRepository loanCalculationRepository) {
        this.loanCalculationRepository = loanCalculationRepository;
    }

    @Override
    public List<Profession> getAllProfessions() {
        return Arrays.asList(Profession.values());
    }

    @Override
    public LoanCalculationResponse calculate (LoanCalculationRequest request) {
        Profession profession = request.getProfession();

        BigDecimal requestedAmount = BigDecimal.valueOf(request.getRequestedAmount());
        int termMonths = request.getTermMonths();

        BigDecimal monthlyRate = profession.getMonthlyInterestRate();
        BigDecimal maxLimit = profession.getMaxCreditLimit();

        if (requestedAmount.compareTo(maxLimit) > 0) {
            throw new LimitExceededException("Limit aşıldı. Meslek: " + profession
                    + " Max: " + maxLimit + " İstenen: " + requestedAmount);
        }

        BigDecimal months = BigDecimal.valueOf(termMonths);

        BigDecimal totalPayment = requestedAmount.multiply(
                BigDecimal.ONE.add(monthlyRate.multiply(months))
        );

        totalPayment = totalPayment.setScale(2, RoundingMode.HALF_UP);

        BigDecimal monthlyInstallment = totalPayment.divide(months, 2, RoundingMode.HALF_UP);

        LoanCalculation entity = new LoanCalculation();
        entity.setProfession(profession);
        entity.setRequestedAmount(request.getRequestedAmount());
        entity.setTermMonths(termMonths);
        entity.setMonthlyInterestRate(monthlyRate);
        entity.setTotalPayment(totalPayment);
        entity.setMonthlyInstallment(monthlyInstallment);

        LoanCalculation saved = loanCalculationRepository.save(entity);

        LoanCalculationResponse response = new LoanCalculationResponse();
        response.setId(saved.getId());
        response.setProfession(saved.getProfession());
        response.setRequestedAmount(saved.getRequestedAmount());
        response.setTermMonths(saved.getTermMonths());
        response.setMonthlyInterestRate(saved.getMonthlyInterestRate());
        response.setTotalPayment(saved.getTotalPayment());
        response.setMonthlyInstallment(saved.getMonthlyInstallment());

        return response;
    }
}
