package model.requests;


public class ValidateRequest {

	public String customer;
	public String ccyPair;
	public String type;
	public String direction;
	public String tradeDate;
	public double amount1;
	public double amount2;
	public double rate;
	public String valueDate;
	public String legalEntity;
	public String trader;

	/**
	 * No args constructor for use in serialization
	 *
	 */
	public ValidateRequest() {
	}

	/**
	 *  @param customer
	 * @param ccyPair
	 * @param type
	 * @param direction
	 * @param tradeDate
	 * @param amount1
	 * @param amount2
	 * @param rate
	 * @param valueDate
	 * @param legalEntity
	 * @param trader
	 */
	public ValidateRequest(String customer, String ccyPair, String type, String direction, String tradeDate, double amount1, double amount2, double rate, String valueDate, String legalEntity, String trader) {
		super();
		this.customer = customer;
		this.ccyPair = ccyPair;
		this.type = type;
		this.direction = direction;
		this.tradeDate = tradeDate;
		this.amount1 = amount1;
		this.amount2 = amount2;
		this.rate = rate;
		this.valueDate = valueDate;
		this.legalEntity = legalEntity;
		this.trader = trader;
	}

}
