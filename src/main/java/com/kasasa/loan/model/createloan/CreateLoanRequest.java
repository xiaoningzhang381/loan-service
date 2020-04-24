package com.kasasa.loan.model.createloan;

import lombok.*;

import java.math.BigDecimal;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class CreateLoanRequest {
    private String name;
    private String ssn;
    private String dob;
    private String type;
    private Integer termInDays;
    private Double principal;
    private Double rate;
}
