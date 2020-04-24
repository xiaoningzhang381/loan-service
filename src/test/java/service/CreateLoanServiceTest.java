package service;

import com.kasasa.loan.converter.LoanRecordConverter;
import com.kasasa.loan.dao.InsertLoanDao;
import com.kasasa.loan.helper.AprCalculator;
import com.kasasa.loan.model.createloan.CreateLoanRequest;
import com.kasasa.loan.model.createloan.CreateLoanResponse;
import com.kasasa.loan.model.db.LoanRecord;
import com.kasasa.loan.service.CreateLoanService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CreateLoanServiceTest {

    private CreateLoanService createLoanService;

    @Mock
    private AprCalculator aprCalculator;

    @Mock
    private LoanRecordConverter loanRecordConverter;

    @Mock
    private InsertLoanDao insertLoanDao;

    @Mock
    private CreateLoanRequest createLoanRequest;

    @Mock
    private LoanRecord loanRecord;

    private Double apr;
    String loanId;

    @BeforeEach
    void setUp() {

        createLoanService = new CreateLoanService(aprCalculator,
                loanRecordConverter,
                insertLoanDao
                );

        apr = 0.06;
        loanId = "fasdfdsf";
    }

    @Test
    void create() {

        when(aprCalculator.calculateApr(any()))
                .thenReturn(apr);

        when(loanRecordConverter.convert(any(), anyDouble()))
                .thenReturn(loanRecord);

        when(insertLoanDao.insert(any()))
                .thenReturn(loanId);

        ResponseEntity<CreateLoanResponse> actualCreateLoanResponseEntity =
                createLoanService.create(createLoanRequest);

        verify(aprCalculator).calculateApr(createLoanRequest);
        verify(loanRecordConverter).convert(createLoanRequest, apr);
        verify(insertLoanDao).insert(loanRecord);

        ResponseEntity<CreateLoanResponse> expectedCreateLoanResponseEntity =
                new ResponseEntity<>(
                        CreateLoanResponse.builder()
                                .loanId(loanId)
                                .build(),
                        HttpStatus.CREATED
                );

        assertThat(actualCreateLoanResponseEntity, equalTo(expectedCreateLoanResponseEntity));

    }
}