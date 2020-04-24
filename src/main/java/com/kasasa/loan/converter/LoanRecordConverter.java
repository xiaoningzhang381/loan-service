package com.kasasa.loan.converter;

import com.kasasa.loan.model.createloan.CreateLoanRequest;
import com.kasasa.loan.model.db.LoanRecord;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class LoanRecordConverter {

    public LoanRecord convert(
            CreateLoanRequest createLoanRequest,
            Double apr
    ) {
        LoanRecord loanRecord = LoanRecord.builder()
                .name(createLoanRequest.getName())
                .ssn(createLoanRequest.getSsn())
                .dob(createLoanRequest.getDob())
                .type(createLoanRequest.getType())
                .termInDays(createLoanRequest.getTermInDays())
                .principal(createLoanRequest.getPrincipal())
                .rate(createLoanRequest.getRate())
                .apr(apr)
                .build();

        return loanRecord;
    }
}
