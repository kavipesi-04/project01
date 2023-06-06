Feature: To validate Facebook Login Page

Scenario: Valid login credentials with incorrect username and password

Given User is on facebook login page
And  User Enter username and password
And user click login button
Then User verify error message

