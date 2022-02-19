@GetCEOName
Feature: this feature is to get the CEO name from the orange HRM App
Scenario Outline: This test is to verify CEO name
Given the user is logged in successfully and is on homepage
When the user clicks on the directory option from the Menu bar
And the user selects the job title as "Chief Executive Officer" from the dropdown using "text"
And clicks the search button
Then the user should see the CEO name as  "John Smith"

Examples:
|CEO_Name|
|john Smith|