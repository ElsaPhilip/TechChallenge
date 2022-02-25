Feature: To Check SingleUser Insert API is working

@APITest1
Scenario Outline: To test the Post insertPerson API
Given Set insertPerson request HEADER <Natid> <salary> <tax> <gender> <DOB> <name>
When Send a POST insertPerson API HTTP request
Then Receive valid POST Response
And Validate the Response

Examples:
|Natid|salary|tax|gender|DOB|name|
|123111|10000|3000|M|11012005|User1|
|124111|10000|3000|M|11012005|User2|
