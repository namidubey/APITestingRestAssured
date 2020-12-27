#Rest Assured API framework

###How to run tests:
Run the tests using feature files present in features folder. There are 2 feature files
1. validateTrade Feature File
2. validateBatch Feature File

###Scenarios of ValidateTrade POST API
1. Successful response when Validate Trade payload is given.
2. Validate Trade API gives error when Value Date is before Trade Date.
3. Validate Trade API gives error when counterparty is not supported one.
4. Validate Trade API gives error when date fall on weekend
5. Validate Trade API gives error when currency format is not correct
6. Validate Trade API gives error when value date is not as per product type
8. Validate Trade request is successful when valid options payload is given

###Scenarios of ValidateBatch POST API
1. Validate response of batch request when 1 valid and 1 invalid array given.
2. Validate response of batch request when both valid arrays are given.
3. Validate response of batch request when both invalid arrays are given.
