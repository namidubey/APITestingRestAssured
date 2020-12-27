package testData;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import io.cucumber.datatable.DataTable;
import model.requests.ValidateTradeRequest;

public class createRequestData {

	public static ValidateTradeRequest createValidateTradeValidRequest(DataTable dataTable) {
		//Write the code to handle Data Table
		Map<String,String> data = dataTable.transpose().asMap(String.class, String.class);
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

	public static List<ValidateTradeRequest> createBatchRequest(List<DataTable> dataTables) {
		List<ValidateTradeRequest> validateTradeRequests = new ArrayList<>();
		for (DataTable dataTable: dataTables) {
			validateTradeRequests.add(createValidateTradeValidRequest(dataTable));
		}
		return validateTradeRequests;
	}

	public static File createBatchRequest(String filePath) {
		File file = new File(filePath);
		return file;
	}
}
