package com.kasasa.loan.converter;

import com.kasasa.loan.model.createloan.CreateLoanRequest;
import com.kasasa.loan.model.db.LoanRecord;
import com.kasasa.loan.model.getloan.GetLoanResponse;
import org.springframework.stereotype.Component;

@Component
public class GetLoanResponseConverter {

    public GetLoanResponse convert(
            LoanRecord loanRecord
    ) {
        GetLoanResponse getLoanResponse = GetLoanResponse.builder()
                .name(loanRecord.getName())
                .ssn(loanRecord.getSsn())
                .dob(loanRecord.getDob())
                .type(loanRecord.getType())
                .termInDays(loanRecord.getTermInDays())
                .principal(loanRecord.getPrincipal())
                .rate(loanRecord.getRate())
                .apr(loanRecord.getApr())
                .build();

        return getLoanResponse;
    }
}
