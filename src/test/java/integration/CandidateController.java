package integration;

import com.avol.interviewer.Application;
import com.avol.interviewer.dto.CandidateDto;
import com.google.gson.Gson;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import java.net.URL;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebIntegrationTest("server.port:0") //spring boot start the server with random port no.
public class CandidateController {

    @Value("${local.server.port}")
    private int port;

	private URL base;
	private RestTemplate template;
	private Gson gson;

	@Before
	public void setUp() throws Exception {
		this.base = new URL("http://localhost:" + port + "/api/candidates");
		template = new TestRestTemplate();
		gson = new Gson();
	}

	@Test
	public void createCandidateTest() throws Exception {
		ResponseEntity<CandidateDto> response = template.postForEntity(base.toString(), new CandidateDto("test", "test", "test", "test", null), CandidateDto.class);
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}

	@Test
	public void createCandidateFailTest() throws Exception {
		ResponseEntity<CandidateDto> response = template.postForEntity(base.toString(), new CandidateDto(null, null, null, null, null), CandidateDto.class);
		assertThat(response.getStatusCode(), equalTo(HttpStatus.BAD_REQUEST));
	}

	@Test
	public void getCandidateTest() throws Exception {
		ResponseEntity<CandidateDto> response = template.postForEntity(base.toString(), new CandidateDto("test1", "test1", "test1", "test1", null), CandidateDto.class);
		assertEquals(HttpStatus.OK, response.getStatusCode());

		response = template.getForEntity(base.toString()+"/"+response.getBody().getId(), CandidateDto.class);
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(response.getBody().getFirstName(), "test1");

	}
}
