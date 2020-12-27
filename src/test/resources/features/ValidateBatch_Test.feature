Feature: Validation of the batch information for FX Spot, Forward, Options of trade-validation-service
  Description:
  API - http://localhost:12345/validateBatch

  Scenario: Successful response when correct payload is given
    Given Validate Batch Post API
    When I invoke validate batch request with given valid payload
    Then Success response received for batch request

  Scenario: Failure response when 1 sub array is incorrect
    Given Validate Batch Post API
    When I invoke validate batch request with given payload
    Then Failure response received for batch request

