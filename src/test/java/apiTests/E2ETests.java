package apiTests;

import org.junit.Assert;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class E2ETests {

	public static void main(String[] args) {
		String baseUrl = "http://localhost:12345";

		RestAssured.baseURI = baseUrl;
		RequestSpecification request = RestAssured.given();

		request.header("Accept", "*/*");
		request.header("Content-Type", "application/json");

		Response response = request.body("{\"customer\":\"PLUTO1\",\n" +
				"      \"ccyPair\":\"EURUSD\",\n" +
				"      \"type\":\"Forward\",\n" +
				"      \"direction\":\"SELL\",\n" +
				"      \"tradeDate\":\"2017-08-11\",\n" +
				"      \"amount1\":1000000.00,\n" +
				"      \"amount2\":1120000.00,\n" +
				"      \"rate\":1.12,\n" +
				"      \"valueDate\":\"2017-08-22\",\n" +
				"      \"legalEntity\":\"CS  Zurich\",\n" +
				"      \"trader\":\"Johann Baumfiddler\"\n" +
				"}").post("/validate");

		Assert.assertEquals(response.getStatusCode(), 200);

		String jsonString = response.asString();
		String valueDate = JsonPath.from(jsonString).get("status");
		String tradeDate = JsonPath.from(jsonString).get("messages");
		System.out.println(valueDate);
		System.out.println(tradeDate);
	}
}
