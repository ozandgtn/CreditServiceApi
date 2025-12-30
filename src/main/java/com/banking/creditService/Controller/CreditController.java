package com.banking.creditService.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.banking.creditService.Dto.LoanCalculationRequest;
import com.banking.creditService.Dto.LoanCalculationResponse;

import com.banking.creditService.Business.ICreditService;
import com.banking.creditService.Entities.LoanCalculation;
import com.banking.creditService.Enums.Profession;


@RestController
@RequestMapping("/api")

public class CreditController {
	
	private ICreditService creditService;
	
	
	@Autowired
	public CreditController(ICreditService creditService) {
		this.creditService=creditService;
	}
	
	@GetMapping("/professions")
	public List<Profession> get(){
		return creditService.getAllProfessions();

	}

	  @PostMapping("/calculate")
	    public ResponseEntity<LoanCalculationResponse> calculate(@RequestBody LoanCalculationRequest request) {
	        LoanCalculationResponse response = creditService.calculate(request);
	        return new ResponseEntity<>(response, HttpStatus.OK);
	    }

	
}


