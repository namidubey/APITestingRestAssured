package api;

import java.io.File;
import java.util.List;

import utilities.apiUtils.IRestResponse;
import utilities.apiUtils.RestResponse;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import model.requests.ValidateTradeRequest;
import model.responses.ValidateTradeResponse;
import step_definitions.BaseStep;

public class APIPost {
	private final RequestSpecification request;

	public APIPost() {
		RestAssured.baseURI = BaseStep.getBaseUrl();
		request = RestAssured.given();
		request.header("Accept", "*/*");
		request.header("Content-Type", "application/json");
	}

	public IRestResponse<ValidateTradeResponse> postValidateTrade(ValidateTradeRequest validateTradeRequest) {
		Response response =  request.body(validateTradeRequest).post("/validate");
		return new RestResponse(ValidateTradeResponse.class, response);
	}

	public IRestResponse<List<ValidateTradeResponse>> postValidateBatch(List<ValidateTradeRequest> validateTradeRequests) {
		Response response = request.body(validateTradeRequests).post("/validateBatch");
		return new RestResponse(ValidateTradeResponse.class, response);
	}

	public Response postValidateBatch(File file) {
		return request.body(file).post("/validateBatch");
	}
}
