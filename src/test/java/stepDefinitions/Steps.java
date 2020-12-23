package stepDefinitions;

import org.junit.Assert;

import apiEngine.model.requests.ValidateRequest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Steps {

	RequestSpecification request;
	Response response;

	@Given("^Endpoint and payload for validation$")
	public void endpointAndPayload() {
		String baseUrl = "http://localhost:12345";

		RestAssured.baseURI = baseUrl;
		request = RestAssured.given();

		request.header("Accept", "*/*");
		request.header("Content-Type", "application/json");
	}

	@When("^Endpoint is hit with correct payload$")
	public void correctPayloadGiven() {
		ValidateRequest validateRequest = new ValidateRequest("PLUTO1",
				"EURUSD",
				"Forward",
				"SELL",
				"2017-08-11",
				1000000.00,
				1120000.00,
				1.12,
				"2017-08-22",
				"CS  Zurich",
				"Johann Baumfiddler"
				);
		response = request.body(validateRequest).post("/validate");
	}

	@Then("^Response recieved as 200 and success$")
	public void successApiResult() {
		Assert.assertEquals(response.getStatusCode(), 200);

		String jsonString = response.asString();
		String valueDate = JsonPath.from(jsonString).get("status");
		String tradeDate = JsonPath.from(jsonString).get("messages");
		System.out.println(valueDate);
		System.out.println(tradeDate);
	}
}
