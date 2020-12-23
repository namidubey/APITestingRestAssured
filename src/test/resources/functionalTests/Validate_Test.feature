Feature: Validation of the trade information for FX Spot, Forward, Options of trade-validation-service
  Description:

  trade-validation-service Swagger URL : http://localhost:12345/swagger-ui.html

  Scenario: Successful response when correct payload is given
    Given Endpoint and payload for validation
    When Endpoint is hit with correct payload
    Then Response recieved as 200 and success

#  Scenario: Value Date cannot be before trade date
#    Given Endpoint and payload for validation
#    When Value Date is before Trade Date
#    Then Error status with message occurs
#
#  Scenario: Value date cannot fall on weekend or non-working day for currency
#    Given Endpoint and payload for validation
#    When Value date is on weekend
#    Then Error status with message occurs
#
#  Scenario:
