package com.kasasa.loan.controller;

import com.kasasa.loan.model.createloan.CreateLoanRequest;
import com.kasasa.loan.model.createloan.CreateLoanResponse;
import com.kasasa.loan.service.CreateLoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class CreateLoanController {

	private final CreateLoanService createLoanService;

	@Autowired
	public CreateLoanController(CreateLoanService createLoanService) {
		this.createLoanService = createLoanService;
	}

	@RequestMapping(
			consumes="application/json",
			produces="application/json",
			value = "/loan",
			method = RequestMethod.POST)
	public ResponseEntity<CreateLoanResponse> createLoan(
			@RequestBody CreateLoanRequest createLoanRequest
	)
	{
		ResponseEntity<CreateLoanResponse> createLoanResponseEntity =
				createLoanService.create(createLoanRequest);

		return createLoanResponseEntity;
	}

}
