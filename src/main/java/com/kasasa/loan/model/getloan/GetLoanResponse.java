package com.kasasa.loan.model.getloan;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@Data
@Builder
@EqualsAndHashCode
public class GetLoanResponse {
    private String name;
    private String ssn;
    private String dob;
    private String type;
    private Integer termInDays;
    private Double principal;
    private Double rate;
    private Double apr;
}
