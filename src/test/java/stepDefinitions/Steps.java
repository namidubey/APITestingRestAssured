package stepDefinitions;

import org.junit.Assert;

import apiEngine.Endpoints;
import apiEngine.model.requests.ValidateRequest;
import apiEngine.model.responses.ValidateResponse;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

public class Steps {

	private static Response response;
	private static ValidateResponse validateResponse;

	@Given("^Endpoint and payload for trade validation$")
	public void endpointAndPayload() {

	}

	@When("^Endpoint is hit with correct payload$")
	public void correctPayloadGiven() {
		ValidateRequest validateRequest = new ValidateRequest(
				"PLUTO1",
				"EURUSD",
				"Forward",
				"SELL",
				"2017-08-11",
				1000000.00,
				1120000.00,
				1.12,
				"2017-08-22",
				"CS Zurich",
				"Johann Baumfiddler"
				);
		response = Endpoints.postValidateTrade(validateRequest);
	}

	@Then("^Response recieved as 200 and success$")
	public void successApiResult() {
		validateResponse = response.getBody().as(ValidateResponse.class);
		Assert.assertEquals(response.getStatusCode(), 200);
		Assert.assertEquals("Status is", validateResponse.getStatus(), "SUCCESS");
	}
}
