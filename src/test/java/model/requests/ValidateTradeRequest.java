package model.requests;

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

	public String getCustomer() {
		return customer;
	}

	public String getCcyPair() {
		return ccyPair;
	}

	public String getType() {
		return type;
	}

	public String getDirection() {
		return direction;
	}

	public String getTradeDate() {
		return tradeDate;
	}

	public double getAmount1() {
		return amount1;
	}

	public double getAmount2() {
		return amount2;
	}

	public double getRate() {
		return rate;
	}

	public String getValueDate() {
		return valueDate;
	}

	public String getLegalEntity() {
		return legalEntity;
	}

	public String getTrader() {
		return trader;
	}

	public static class Builder {
		private String customer;
		private String ccyPair;
		private String type;
		private String direction;
		private String tradeDate;
		private double amount1;
		private double amount2;
		private double rate;
		private String valueDate;
		private String legalEntity;
		private String trader;

		public Builder(String customer, String trader) {
			this.customer = customer;
			this.trader = trader;
		}

		public Builder ccyPair(String ccyPair) {
			this.ccyPair = ccyPair;
			return this;
		}

		public Builder tradeType(String type) {
			this.type = type;
			return this;
		}

		public Builder tradeDirection(String direction) {
			this.direction = direction;
			return this;
		}

		public Builder tradeDate(String tradeDate) {
			this.tradeDate = tradeDate;
			return this;
		}

		public Builder amount1(double amount1) {
			this.amount1 = amount1;
			return this;
		}

		public Builder amount2(double amount2) {
			this.amount2 = amount2;
			return this;
		}

		public Builder rate(double rate) {
			this.rate = rate;
			return this;
		}

		public Builder valueDate(String valueDate) {
			this.valueDate = valueDate;
			return this;
		}

		public Builder legalEntity(String legalEntity) {
			this.legalEntity = legalEntity;
			return this;
		}

		public ValidateTradeRequest build() {
			ValidateTradeRequest validateTradeRequest = new ValidateTradeRequest(this);
			return validateTradeRequest;
		}

	}

	private ValidateTradeRequest(Builder builder) {
		this.customer = builder.customer;
		this.ccyPair = builder.ccyPair;
		this.type = builder.type;
		this.legalEntity = builder.legalEntity;
		this.amount1 = builder.amount1;
		this.amount2 = builder.amount2;
		this.rate = builder.rate;
		this.direction = builder.direction;
		this.tradeDate = builder.tradeDate;
		this.valueDate = builder.valueDate;
		this.trader = builder.trader;
	}

}

