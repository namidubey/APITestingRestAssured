package apiUtils;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import model.requests.ValidateTradeRequest;
import model.responses.ValidateTradeResponse;

public class Endpoints {

	private final RequestSpecification request;

	public Endpoints(String baseUrl) {
		RestAssured.baseURI = baseUrl;
		request = RestAssured.given();
		request.header("Accept", "*/*");
		request.header("Content-Type", "application/json");
	}

	public IRestResponse<ValidateTradeResponse> postValidateTrade(ValidateTradeRequest validateTradeRequest) {
		Response response =  request.body(validateTradeRequest).post(Route.getValidateTrade());
		return new RestResponse(ValidateTradeResponse.class, response);
	}
}
