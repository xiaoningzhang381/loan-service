package com.kasasa.loan.dao;

import com.kasasa.loan.model.createloan.CreateLoanRequest;
import com.kasasa.loan.model.db.LoanRecord;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class InsertLoanDao {

    public String insert(
            LoanRecord loanRecord
    ) {
        return "1";
    }
}
