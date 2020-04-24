package com.kasasa.loan.model.createloan;

import lombok.*;

import java.math.BigDecimal;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode

public class CreateLoanResponse {
    private String loanId;
}
