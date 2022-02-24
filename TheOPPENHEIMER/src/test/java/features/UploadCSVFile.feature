Feature: Add User from CSVFile

@valid
Scenario: To check the CSV fileupload function with a valid data and validate the records are added
Given User is on The Oppenheimer Project Landing page
When User select the Browse button to upload the "valid" file
Then Validate "24" records are added

@invalid
Scenario: To check the CSV fileupload function with an invalid data and validate the record is added
Given User is on The Oppenheimer Project Landing page
When User select the Browse button to upload the "invalid" file
Then Validate "0" records are added


@valid
Scenario: To check the natid field is masked from the 5th character onwards
Given User is on The Oppenheimer Project Landing page
Then Verify the natid is masked from the 5th cahracter
