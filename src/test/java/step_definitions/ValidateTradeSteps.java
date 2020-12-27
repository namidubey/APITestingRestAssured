package step_definitions;
import org.junit.Assert;

import api.APIPost;
import apiUtils.IRestResponse;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.requests.ValidateTradeRequest;
import model.responses.ValidateTradeResponse;
import testData.createRequestData;

public class ValidateTradeSteps extends BaseStep{

	private static IRestResponse<ValidateTradeResponse> validateTradeResponse;
	private APIPost endpoints;
	private static ValidateTradeRequest validateTradeRequest;

	@Given("^Validate Trade Post API$")
	public void validate_trade_post_api() {
		endpoints = getEndpoints();
	}

	@When("^I invoke validate trade request with given data$")
	public void payloadGiven(DataTable payLoad) {
		APIPost apiPost = new APIPost();
		validateTradeRequest = createRequestData.createValidateTradeValidRequest(payLoad);
		validateTradeResponse = apiPost.postValidateTrade(validateTradeRequest);
	}

	@Then("^Success response received$")
	public void successApiResult() {
		Assert.assertTrue(validateTradeResponse.isSuccessful());
		assertStatus("SUCCESS");
	}

	@Then("^Failed due to valueDate is before tradeDate$")
	public void error_status_with_message_occurs() {
		assertStatus("ERROR");
		String failureMessageDueToValueDateBeforeTradeDate = "Value date "+validateTradeRequest.getValueDate()+" cannot be null and it has to be after trade date "+validateTradeRequest.getTradeDate()+" ";
		verifyErrorMessage(failureMessageDueToValueDateBeforeTradeDate);
	}

	@Then("^Failed due to counterparty is not supported$")
	public void failed_due_to_counterparty_not_supported() {
		assertStatus("ERROR");
		String failureMessageDueToUnsupportedCounterParty = "Counterparty ["+validateTradeRequest.getCustomer()+"] is not supported. Supported counterparties: [[PLUTO2, PLUTO1]]";
		verifyErrorMessage(failureMessageDueToUnsupportedCounterParty);
	}

	@Then("^Failed due to date fall on weekend or non-working day for currency$")
	public void failed_due_to_date_fall_on_weekend() {
		assertStatus("ERROR");
		String failureMessageDueToDateOnWeekend = "Value date ["+validateTradeRequest.getValueDate()+"] cannot fall on Saturday/Sunday";
		verifyErrorMessage(failureMessageDueToDateOnWeekend);
	}

	@Then("^Failed due to currency not in format$")
	public void failed_due_to_currency_not_in_format() {
		assertStatus("ERROR");
		String failureDueToCurrencyNotInFormat = "Invalid currency pair ["+validateTradeRequest.getCcyPair()+"]";
		verifyErrorMessage(failureDueToCurrencyNotInFormat);
	}

	@Then("^Failed due to valueDate is not as per productType$")
	public void failed_due_to_valueDate_is_not_as_productType() {
		Assert.assertTrue(validateTradeResponse.isFailure());
	}

	public void assertStatus(String expectedValue) {
		Assert.assertEquals("Status is ", expectedValue, validateTradeResponse.getBody().getStatus());
	}

	public void verifyErrorMessage(String expectedError) {
		Assert.assertEquals("Expected error message is ", expectedError, validateTradeResponse.getBody().getMessages().get(0));
	}
}
