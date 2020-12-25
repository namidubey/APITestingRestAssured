Feature: Validation of the trade information for FX Spot, Forward, Options of trade-validation-service
  Description:
  API - http://localhost:12345/validate

  Scenario: Successful response when correct payload is given
   Given Validate Trade Post API
    When Post request is made
      | key      | value |
      | customer | PLUTO1 |
      | trader   | Johann Baumfiddler |
      | ccyPair  | EURUSD |
      | type     | Spot   |
      | direction| SELL   |
      | tradeDate|2017-08-11|
      | valueDate|2017-08-22 |
      | amount1  | 1000000.00|
      | amount2  | 1120000.00|
      | rate| 1.12 |
      |legalEntity| CS Zurich |
    Then Success response recieved
    When Post request is made
      | key      | value |
      | customer | PLUTO1 |
      | trader   | Johann Baumfiddler |
      | ccyPair  | EURUSD |
      | type     | Spot   |
      | direction| SELL   |
      | tradeDate|2017-08-11|
      | valueDate|2017-08-10 |
      | amount1  | 1000000.00|
      | amount2  | 1120000.00|
      | rate| 1.12 |
      |legalEntity| CS Zurich |
    Then Failed due to valueDate is before tradeDate
    When Post request is made
      | key      | value |
      | customer | PLUTO4 |
      | trader   | Johann Baumfiddler |
      | ccyPair  | EURUSD |
      | type     | Spot   |
      | direction| SELL   |
      | tradeDate|2017-08-11|
      | valueDate|2017-08-22 |
      | amount1  | 1000000.00|
      | amount2  | 1120000.00|
      | rate| 1.12 |
      |legalEntity| CS Zurich |
  Then Failed due to counterparty is not supported
    When Post request is made
      | key      | value |
      | customer | PLUTO1 |
      | trader   | Johann Baumfiddler |
      | ccyPair  | EURUSD |
      | type     | Spot   |
      | direction| SELL   |
      | tradeDate|2017-08-11|
      | valueDate|2017-08-27 |
      | amount1  | 1000000.00|
      | amount2  | 1120000.00|
      | rate| 1.12 |
      |legalEntity| CS Zurich |
  Then Failed due to date fall on weekend or non-working day for currency
    When Post request is made
      | key      | value |
      | customer | PLUTO1 |
      | trader   | Johann Baumfiddler |
      | ccyPair  | JPY |
      | type     | Spot   |
      | direction| SELL   |
      | tradeDate|2017-08-11|
      | valueDate|2017-08-22 |
      | amount1  | 1000000.00|
      | amount2  | 1120000.00|
      | rate| 1.12 |
      |legalEntity| CS Zurich |
  Then Failed due to currency not in format
    When Post request is made
      | key      | value |
      | customer | PLUTO1 |
      | trader   | Johann Baumfiddler |
      | ccyPair  | EURUSD |
      | type     | XYZ   |
      | direction| SELL   |
      | tradeDate|2017-08-11|
      | valueDate|2017-08-22 |
      | amount1  | 1000000.00|
      | amount2  | 1120000.00|
      | rate| 1.12 |
      |legalEntity| CS Zurich |
  Then Failed due to valueDate is not as per productType

