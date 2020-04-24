package acceptance;

import com.kasasa.loan.LoanServiceApplication;
import com.kasasa.loan.model.createloan.CreateLoanRequest;
import com.kasasa.loan.model.createloan.CreateLoanResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import java.net.URL;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest(classes = LoanServiceApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PostLoanTest {

	@LocalServerPort
	private int port;

	private URL base;

	@Autowired
	private TestRestTemplate template;

    @BeforeEach
    public void setUp() throws Exception {
        this.base = new URL("http://localhost:" + port + "/loan");
    }

    @Test
    public void getHello() throws Exception {

        CreateLoanRequest createLoanRequest = CreateLoanRequest.builder()
                .dob("1/1/1981")
                .principal(105000.00)
                .rate(0.05)
                .name("Bob")
                .ssn("123-45-6789")
                .termInDays(600)
                .type("student")
                .build();

        ResponseEntity<CreateLoanResponse> response = template.postForEntity(
                base.toString(),
                createLoanRequest,
                CreateLoanResponse.class);

        assertThat(response.getBody()).isEqualTo(CreateLoanResponse.builder()
                .loanId("1")
                .build());
    }
}
