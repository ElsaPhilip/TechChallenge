Feature: To Check insertMultiplePerson API is working

@APITest
Scenario Outline: To test the Post insertMultiplePerson API
Given Set insertMultiplePerson request HEADER <Natid> <salary> <tax> <gender> <DOB> <name>
When Send a POST insertPerson API HTTP request
Then Receive valid POST Response
And Validate the Response
Examples:
|Natid|salary|tax|gender|DOB|name|
|123111|10000|3000|M|11012005|User1|
|124111|10000|3000|M|11012005|User2|

