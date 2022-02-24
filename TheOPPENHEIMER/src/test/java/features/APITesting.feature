Feature: To Check API is working

@APITest

Scenario: To test the getTaxRelief API
Given I Set request HEADER
When Send a GET HTTP request
Then I receive valid Response
And Validate the Response

@APITest
Scenario: To test the getTaxReliefSummary API
Given I Set request HEADER
When Send a GET getTaxReliefSummary API HTTP request
Then I receive valid Response
And Validate the Response

@APITest
Scenario: To test the Post insertPerson API
Given Set insertPerson request HEADER
When Send a POST insertPerson API HTTP request
Then Receive valid POST Response
And Validate the Response

@APITest
Scenario: To test the Post insertMultiplePerson API
Given Set insertMultiplePerson request HEADER
When Send a POST insertPerson API HTTP request
Then Receive valid POST Response
And Validate the Response

