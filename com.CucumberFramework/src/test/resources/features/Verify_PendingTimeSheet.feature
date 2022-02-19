@timesheets
Feature: This feature is to getting Pending Timesheets
Scenario Outline: This test is to verify the Pending Timesheets
Given the user is on the Directory page
And the user clicks on time option from the menu
And the user enters the name as "John Smith"
And clicks on view button
Then the user should see the message as "<message>"

Examples:
|message|
|No Timesheet Found|