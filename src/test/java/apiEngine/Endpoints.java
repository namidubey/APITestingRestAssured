package apiEngine;

import apiEngine.model.requests.ValidateRequest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Endpoints {
	private static final String BASE_URL = "http://localhost:12345";

	public static Response postValidateTrade(ValidateRequest validateRequest) {
		RestAssured.baseURI = BASE_URL;
		RequestSpecification request = RestAssured.given();
		request.header("Accept", "*/*");
		request.header("Content-Type", "application/json");
		return request.body(validateRequest).post("/validate");
	}
}
