Feature: Validation of the batch information for FX Spot, Forward, Options of trade-validation-service
  Description:
  API - http://localhost:12345/validateBatch

  Scenario: Successful response when correct payload is given
    Given Validate Batch Post API
    When I invoke validate batch request with given data
    Then Success response received for batch
