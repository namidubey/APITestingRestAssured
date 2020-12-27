package testData;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import io.cucumber.datatable.DataTable;
import logs.Logs;
import model.requests.ValidateTradeRequest;

public class buildRequestPayload {

	public static ValidateTradeRequest createValidateTradeValidRequest(DataTable dataTable) {
		//Write the code to handle Data Table
		Map<String,String> data = dataTable.transpose().asMap(String.class, String.class);
		Logs.getInstance().infoLog("Validate Trade payload is build");
		return ValidateTradeRequest.builder()
				.customer(data.get("customer"))
				.trader(data.get("trader"))
				.ccyPair(data.get("ccyPair"))
				.type(data.get("type"))
				.direction(data.get("direction"))
				.tradeDate(data.get("tradeDate"))
				.valueDate(data.get("valueDate"))
				.amount1(Double.parseDouble(data.get("amount1")))
				.amount2(Double.parseDouble(data.get("amount2")))
				.rate(Double.parseDouble(data.get("rate")))
				.legalEntity(data.get("legalEntity"))
				.build();
	}

	public static ValidateTradeRequest createValidateTradeValidRequestForOptions(DataTable dataTable) {
		//Write the code to handle Data Table
		Map<String,String> data = dataTable.transpose().asMap(String.class, String.class);
		Logs.getInstance().infoLog("Validate Trade for Options payload is build");
		return ValidateTradeRequest.builder()
				.customer(data.get("customer"))
				.trader(data.get("trader"))
				.ccyPair(data.get("ccyPair"))
				.type(data.get("type"))
				.direction(data.get("direction"))
				.tradeDate(data.get("tradeDate"))
				.amount1(Double.parseDouble(data.get("amount1")))
				.amount2(Double.parseDouble(data.get("amount2")))
				.rate(Double.parseDouble(data.get("rate")))
				.legalEntity(data.get("legalEntity"))
				.deliveryDate(data.get("deliveryDate"))
				.expiryDate(data.get("expiryDate"))
				.payCcy(data.get("payCcy"))
				.premium(data.get("premium"))
				.premiumCcy(data.get("premiumCcy"))
				.premiumDate(data.get("premiumDate"))
				.premiumType(data.get("premiumType"))
				.strategy(data.get("strategy"))
				.style(data.get("style"))
				.build();
	}

	public static List<ValidateTradeRequest> createBatchRequest(List<DataTable> dataTables) {
		List<ValidateTradeRequest> validateTradeRequests = new ArrayList<>();
		Logs.getInstance().infoLog("Validate Batch payload is build");
		for (DataTable dataTable: dataTables) {
			validateTradeRequests.add(createValidateTradeValidRequest(dataTable));
		}
		return validateTradeRequests;
	}

	public static File createBatchRequest(String filePath) {
		Logs.getInstance().infoLog("Validate Batch payload is serialized from Json file");
		return new File(filePath);
	}
}
