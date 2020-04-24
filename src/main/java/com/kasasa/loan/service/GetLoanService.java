package com.kasasa.loan.service;

import com.kasasa.loan.converter.GetLoanResponseConverter;
import com.kasasa.loan.converter.LoanRecordConverter;
import com.kasasa.loan.dao.GetLoanDao;
import com.kasasa.loan.model.createloan.CreateLoanResponse;
import com.kasasa.loan.model.db.LoanRecord;
import com.kasasa.loan.model.getloan.GetLoanResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@Component
public class GetLoanService {
    private final GetLoanDao getLoanDao;
    private final GetLoanResponseConverter getLoanResponseConverter;

    @Autowired
    public GetLoanService(GetLoanDao getLoanDao,
                         GetLoanResponseConverter getLoanResponseConverter) {
        this.getLoanDao = getLoanDao;
        this.getLoanResponseConverter = getLoanResponseConverter;
    }

    public ResponseEntity<GetLoanResponse> get(
            String loanId
    ) {
        LoanRecord loanRecord = getLoanDao.get(loanId);

        GetLoanResponse getLoanResponse = getLoanResponseConverter.convert(loanRecord);

        HttpStatus httpStatus = OK;

        ResponseEntity<GetLoanResponse> getLoanResponseEntity =
                new ResponseEntity<>(getLoanResponse, httpStatus);

        return getLoanResponseEntity;
    }
}
