package controller;

import com.kasasa.loan.controller.CreateLoanController;
import com.kasasa.loan.model.createloan.CreateLoanRequest;
import com.kasasa.loan.model.createloan.CreateLoanResponse;
import com.kasasa.loan.service.CreateLoanService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.equalTo;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(MockitoExtension.class)
public class CreateLoanControllerTest {

	@Autowired
	private MockMvc mvc;

	@Mock
	private CreateLoanService createLoanService;

	private CreateLoanController createLoanController;

	private ResponseEntity<CreateLoanResponse> createLoanResponseEntity;

	@BeforeEach
	void setUp() {
		createLoanController = new CreateLoanController(createLoanService);

		mvc = MockMvcBuilders.standaloneSetup(createLoanController)
				.build();

		createLoanResponseEntity = new ResponseEntity<>(
				CreateLoanResponse.builder().build(),
				CREATED);
	}


	@Test
	public void createLoan() throws Exception {

		CreateLoanRequest expectedCreateLoanRequest = CreateLoanRequest.builder().build();

		String expectedCreateLoanResponseString = "{\"loanId\":null}";

		when(createLoanService.create(any()))
				.thenReturn(createLoanResponseEntity);

		mvc.perform(MockMvcRequestBuilders
				.post("/loan")
				.content("{}")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isCreated())
				.andExpect(content().string(equalTo(expectedCreateLoanResponseString)));

		Mockito.verify(createLoanService).create(expectedCreateLoanRequest);
	}
}
