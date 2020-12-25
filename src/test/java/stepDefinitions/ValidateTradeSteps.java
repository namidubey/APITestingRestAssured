package stepDefinitions;

import org.junit.Assert;

import apiUtils.Endpoints;
import apiUtils.IRestResponse;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import listeners.TestContext;
import model.requests.ValidateTradeRequest;
import model.responses.ValidateTradeResponse;
import testData.APItestData;

public class ValidateTradeSteps extends BaseStep{

	private static IRestResponse<ValidateTradeResponse> validateTradeResponse;
	private Endpoints endpoints;

	public ValidateTradeSteps(TestContext testContext) {
		super(testContext);
	}

	@Given("^Validate Trade Post API$")
	public void endpointAndPayload() {
		endpoints = getEndpoints();
	}

	@When("^Post request is made$")
	public void payloadGiven(DataTable payLoad) {
		ValidateTradeRequest validateTradeRequest = APItestData.createValdiateTradeValidRequest(payLoad);
		validateTradeResponse = endpoints.postValidateTrade(validateTradeRequest);
	}

	@Then("^Success response recieved$")
	public void successApiResult() {
		Assert.assertTrue(validateTradeResponse.isSuccessful());
		assertStatus("SUCCESS");
	}

	@Then("^Failed due to valueDate is before tradeDate$")
	public void error_status_with_message_occurs() {
		assertStatus("ERROR");
	}

	@Then("^Failed due to counterparty is not supported$")
	public void failed_due_to_counterparty_not_supported() {
		assertStatus("ERROR");
	}

	@Then("^Failed due to date fall on weekend or non-working day for currency$")
	public void failed_due_to_date_fall_on_weekend() {
		assertStatus("ERROR");
	}

	@Then("^Failed due to currency not in format$")
	public void failed_due_to_currency_not_in_format() {
		assertStatus("ERROR");
	}

	@Then("^Failed due to valueDate is not as per the productType$")
	public void failed_due_to_valueDate_is_not_as_productType() {
		Assert.assertNull("Status is", validateTradeResponse.getBody().getStatus());
	}

	public void assertStatus(String expectedValue) {
		Assert.assertEquals("Status is", expectedValue, validateTradeResponse.getBody().getStatus());
	}

	public void verifyErrorMessage(String expectedValue) {
		Assert.assertEquals("", expectedValue, validateTradeResponse.getBody().getMessages());
	}

}
