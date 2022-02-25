Feature: To Check GetTaxRelief API is working

@APITest1

Scenario: To test the getTaxRelief API
Given I Set request HEADER
When Send a GET HTTP request
Then I receive valid Response
And Validate the Response

@APITest1
Scenario: To test the getTaxReliefSummary API
Given I Set request HEADER
When Send a GET getTaxReliefSummary API HTTP request
Then I receive valid Response
And Validate the Response


