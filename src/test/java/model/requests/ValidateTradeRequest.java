package model.requests;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ValidateTradeRequest {
	private final String customer;
	private final String ccyPair;
	private final String type;
	private final String direction;
	private final String tradeDate;
	private final double amount1;
	private final double amount2;
	private final double rate;
	private final String valueDate;
	private final String legalEntity;
	private final String trader;
}

