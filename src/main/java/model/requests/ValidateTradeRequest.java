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
	private final String deliveryDate;
	private final String expiryDate;
	private final String payCcy;
	private final String premium;
	private final String premiumCcy;
	private final String premiumDate;
	private final String premiumType;
	private final String strategy;
	private final String style;
}

