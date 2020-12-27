Feature: Validation of the trade information for FX Spot, Forward, Options of trade-validation-service
  Description:
  API - http://localhost:12345/validate

  Scenario: Successful response when Validate Trade payload is given
   Given Validate Trade Post API
    When I invoke validate trade request with given data
      | customer|trader|ccyPair|type|direction|tradeDate|valueDate|amount1|amount2|rate|legalEntity|
      | PLUTO1|Johann Baumfiddler|EURUSD|Spot|SELL|2017-08-11|2017-08-22|1000000.00|1120000.00|1.12|CS Zurich|
    Then Success response received

  Scenario: Validate Trade API gives error when Value Date is before Trade Date
    Given Validate Trade Post API
    When I invoke validate trade request with given data
      | customer|trader|ccyPair|type|direction|tradeDate|valueDate|amount1|amount2|rate|legalEntity|
      | PLUTO1|Johann Baumfiddler|EURUSD|Spot|SELL|2017-08-11|2017-08-10|1000000.00|1120000.00|1.12|CS Zurich|
    Then Failed due to valueDate is before tradeDate

  Scenario: Validate Trade API gives error when counterparty is not supported one
    Given Validate Trade Post API
    When I invoke validate trade request with given data
      | customer|trader|ccyPair|type|direction|tradeDate|valueDate|amount1|amount2|rate|legalEntity|
      | PLUTO5|Johann Baumfiddler|EURUSD|Spot|SELL|2017-08-11|2017-08-22|1000000.00|1120000.00|1.12|CS Zurich|
  Then Failed due to counterparty is not supported

  Scenario: Validate Trade API gives error when date fall on weekend
    Given Validate Trade Post API
    When I invoke validate trade request with given data
      | customer|trader|ccyPair|type|direction|tradeDate|valueDate|amount1|amount2|rate|legalEntity|
      | PLUTO1|Johann Baumfiddler|EURUSD|Spot|SELL|2017-08-11|2017-08-27|1000000.00|1120000.00|1.12|CS Zurich|
  Then Failed due to date fall on weekend or non-working day for currency

  Scenario: Validate Trade API gives error when currency format is not correct
    Given Validate Trade Post API
    When I invoke validate trade request with given data
      | customer|trader|ccyPair|type|direction|tradeDate|valueDate|amount1|amount2|rate|legalEntity|
      | PLUTO1|Johann Baumfiddler|JPY|Spot|SELL|2017-08-11|2017-08-22|1000000.00|1120000.00|1.12|CS Zurich|
  Then Failed due to currency not in format

  Scenario: Validate Trade API gives error when value date is not as per product type
    Given Validate Trade Post API
    When I invoke validate trade request with given data
      | customer|trader|ccyPair|type|direction|tradeDate|valueDate|amount1|amount2|rate|legalEntity|
      | PLUTO1|Johann Baumfiddler|EURUSD|XYZ|SELL|2017-08-11|2017-08-22|1000000.00|1120000.00|1.12|CS Zurich|
  Then Failed due to valueDate is not as per productType

  Scenario: Validate Trade request is successful when valid options payload is given
    Given Validate Trade Post API
    When I invoke validate trade request for options
      | customer|trader|ccyPair|type|direction|tradeDate|amount1|amount2|rate|legalEntity|deliveryDate|expiryDate|payCcy|premium|premiumCcy|premiumType|premiumDate|strategy|style|
      | PLUTO1|Johann Baumfiddler|EURUSD|Spot|SELL|2017-08-11|1000000.00|1120000.00|1.12|CS Zurich|2017-08-22|2017-08-21|USD|0.20|USD|%USD|2017-08-12 |CALL|EUROPEAN|
