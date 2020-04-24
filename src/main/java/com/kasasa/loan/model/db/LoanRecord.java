package com.kasasa.loan.model.db;

import lombok.*;

import java.math.BigDecimal;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class LoanRecord {
    private String loanId;
    private String name;
    private String ssn;
    private String dob;
    private String type;
    private Integer termInDays;
    private Double principal;
    private Double rate;
    private Double apr;
}
