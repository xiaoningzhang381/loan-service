package com.kasasa.loan.controller;

import com.kasasa.loan.model.createloan.CreateLoanRequest;
import com.kasasa.loan.model.createloan.CreateLoanResponse;
import com.kasasa.loan.model.getloan.GetLoanResponse;
import com.kasasa.loan.service.GetLoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class GetLoanController {

	private final GetLoanService getLoanService;

	@Autowired
	public GetLoanController(GetLoanService getLoanService) {
		this.getLoanService = getLoanService;
	}

	@RequestMapping(value = "/loan/{loanId}", method = RequestMethod.GET)
	public ResponseEntity<GetLoanResponse> getLoan(
			@PathVariable String loanId
	)
	{
		ResponseEntity<GetLoanResponse> getLoanResponseEntity = getLoanService.get(loanId);

		return getLoanResponseEntity;
	}

}
