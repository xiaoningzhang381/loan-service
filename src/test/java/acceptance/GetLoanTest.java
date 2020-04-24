package acceptance;

import com.kasasa.loan.model.getloan.GetLoanResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import java.net.URL;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GetLoanTest {

	@LocalServerPort
	private int port;

	private URL base;

	@Autowired
	private TestRestTemplate template;

    @BeforeEach
    public void setUp() throws Exception {
        this.base = new URL("http://localhost:" + port + "/loan/1");
    }

    @Test
    public void getLoan() throws Exception {

        ResponseEntity<GetLoanResponse> response = template.getForEntity(base.toString(),
                GetLoanResponse.class);

        GetLoanResponse expectedGetLoanResponse = GetLoanResponse.builder()
                .name("Sandeep")
                .ssn("123-456-7890")
                .dob("01/01/2000")
                .type("student")
                .termInDays(730)
                .principal(100000.00)
                .rate(0.04)
                .apr(0.05)
                .build();

        assertThat(response.getBody()).isEqualTo(expectedGetLoanResponse);
    }
}
