package com.kasasa.loan.dao;

import com.kasasa.loan.model.db.LoanRecord;
import org.springframework.stereotype.Component;

@Component
public class GetLoanDao {

    public LoanRecord get(
            String loanId
    ) {
        LoanRecord loanRecord = LoanRecord.builder()
                .name("Sandeep")
                .ssn("123-456-7890")
                .dob("01/01/2000")
                .type("student")
                .termInDays(730)
                .principal(100000.00)
                .rate(0.04)
                .apr(0.05)
                .build();

        return loanRecord;
    }
}
