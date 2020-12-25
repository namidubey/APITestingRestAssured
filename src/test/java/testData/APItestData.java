package testData;

import java.util.List;

import io.cucumber.datatable.DataTable;
import model.requests.ValidateTradeRequest;

public class APItestData {

	public static ValidateTradeRequest createValdiateTradeValidRequest(DataTable dataTable) {
		List<List<String>> data = dataTable.asLists(String.class);
		return new ValidateTradeRequest.Builder(data.get(1).get(1), data.get(2).get(1))
				.ccyPair(data.get(3).get(1))
				.tradeType(data.get(4).get(1))
				.tradeDirection(data.get(5).get(1))
				.tradeDate(data.get(6).get(1))
				.valueDate(data.get(7).get(1))
				.amount1(Double.parseDouble(data.get(8).get(1)))
				.amount2(Double.parseDouble(data.get(9).get(1)))
				.rate(Double.parseDouble(data.get(10).get(1)))
				.legalEntity(data.get(11).get(1))
				.build();

	}
}
