package step_definitions;

import java.io.File;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Assert;

import api.APIPost;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import testData.createRequestData;

public class ValidateTradeBatchSteps extends BaseStep {
	private APIPost endpoints;
	private static Response validateBatchResponse;
	private static File validateBatchRequest;


	@Given("^Validate Batch Post API$")
	public void validate_Batch_Post_API() {
		endpoints = getEndpoints();
	}

	@When("^I invoke validate batch request with given data$")
	public void post_request_for_batch_is_made() {
		APIPost apiPost = new APIPost();
		validateBatchRequest = createRequestData.createBatchRequest("src/test/resources/json/validateBatch.json");
		validateBatchResponse = apiPost.postValidateBatch(validateBatchRequest);
	}

	@Then("^Success response received for batch$")
	public void successApiResult() {
		Assert.assertEquals(200, validateBatchResponse.statusCode());
		assertStatus("Status of validateTrade response", "SUCCESS", 0, "status");
		assertMessage("Message of validateTrade response", "null", 0, 0, "messages");
		assertStatus("Status of invalid array", "ERROR", 1, "status");
		assertMessage("Message of validateTrade failure response", "Counterparty [PLUTO5] is not supported. Supported counterparties: [[PLUTO2, PLUTO1]]", 1, 0, "messages");
	}

	public void assertStatus(String message, String expectedValue, int index, String key) {
		JSONArray arr = new JSONArray(validateBatchResponse.asString());
		JSONObject jObj = arr.getJSONObject(index);
		String status = jObj.getString(key);
		Assert.assertEquals(message, expectedValue, status);
	}

	public void assertMessage(String message, String expectedValue, int array1Index, int array2Index, String key) {
		JSONArray arr = new JSONArray(validateBatchResponse.asString());
		JSONObject jObj = arr.getJSONObject(array1Index);
		if(jObj.isNull(key)){
			if(expectedValue.equals("null")) {
				Assert.assertTrue(true);
			}
		} else
		{
			String status = jObj.getJSONArray(key).getString(array2Index);
			Assert.assertEquals(message, expectedValue, status);
		}
	}
}
