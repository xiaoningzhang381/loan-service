package com.kasasa.loan.service;

import com.kasasa.loan.converter.LoanRecordConverter;
import com.kasasa.loan.dao.InsertLoanDao;
import com.kasasa.loan.helper.AprCalculator;
import com.kasasa.loan.model.createloan.CreateLoanRequest;
import com.kasasa.loan.model.createloan.CreateLoanResponse;
import com.kasasa.loan.model.db.LoanRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import static org.springframework.http.HttpStatus.CREATED;

@Component
public class CreateLoanService {
    private final AprCalculator aprCalculator;
    private final LoanRecordConverter loanRecordConverter;
    private final InsertLoanDao insertLoanDao;

    @Autowired
    public CreateLoanService(AprCalculator aprCalculator, LoanRecordConverter loanRecordConverter, InsertLoanDao insertLoanDao) {
        this.aprCalculator = aprCalculator;
        this.loanRecordConverter = loanRecordConverter;
        this.insertLoanDao = insertLoanDao;
    }

    public ResponseEntity<CreateLoanResponse> create(
            CreateLoanRequest createLoanRequest
    ) {
        Double apr = aprCalculator.calculateApr(createLoanRequest);
        LoanRecord loanRecord = loanRecordConverter.convert(createLoanRequest, apr);
        String loanId = insertLoanDao.insert(loanRecord);

        CreateLoanResponse createLoanResponse = CreateLoanResponse.builder()
                .loanId(loanId)
                .build();

        HttpStatus httpStatus = CREATED;

        ResponseEntity<CreateLoanResponse> createLoanResponseEntity =
                new ResponseEntity<>(createLoanResponse, httpStatus);

        return createLoanResponseEntity;
    }
}
