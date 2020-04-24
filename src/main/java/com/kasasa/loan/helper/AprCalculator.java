package com.kasasa.loan.helper;

import com.kasasa.loan.model.createloan.CreateLoanRequest;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class AprCalculator {

    private final FeeLookup feeLookup;

    public AprCalculator(FeeLookup feeLookup) {
        this.feeLookup = feeLookup;
    }

    public Double calculateApr(
            CreateLoanRequest createLoanRequest
    ) {
        Double fee = feeLookup.lookup(createLoanRequest.getType());
        Double principal = createLoanRequest.getPrincipal();
        Double rate = createLoanRequest.getRate();
        Integer termInDays = createLoanRequest.getTermInDays();

        Double interest = principal * rate * termInDays / 100;

        Double apr = ( ((fee + interest) / principal) / termInDays )
                    * 365 * 100;

        return apr;
    }
}
