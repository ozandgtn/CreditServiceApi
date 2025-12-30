package com.banking.creditService.Business;

import java.util.List;

import com.banking.creditService.Dto.LoanCalculationRequest;
import com.banking.creditService.Dto.LoanCalculationResponse;
import com.banking.creditService.Enums.Profession;

public interface ICreditService {

    List<Profession> getAllProfessions();
    LoanCalculationResponse calculate(LoanCalculationRequest request);
}
