package com.kasasa.loan.helper;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class FeeLookup {

    private final Map<String, Double> loanTypeToFeeMap;

    public FeeLookup() {
        this.loanTypeToFeeMap = new HashMap<>();
        loanTypeToFeeMap.put("student", 0.00);
        loanTypeToFeeMap.put("auto", 500.00);
        loanTypeToFeeMap.put("personal", 750.00);
        loanTypeToFeeMap.put("mortgage", 1500.00);
    }

    public Double lookup(
            String loanType
    ) {
        Double fee = loanTypeToFeeMap.get(loanType);
        return fee;
    }
}
