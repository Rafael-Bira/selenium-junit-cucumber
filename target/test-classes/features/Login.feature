@login
Feature: Login page

    Background:
        Given user goes to the Login page 

    @checkUI
    Scenario: Verify Login page UI
        Then verify that the Login page elements are correctly displayed and enabled

    @forms @regression
    Scenario Outline: Login with invalid credentials
        When user fills the form with username <username> and password <password>
        Then an error message appears with the text <message>
        Examples:
            | username          | password       | message                                                                     |
            | ""                | ""             | "Epic sadface: Username is required"                                        |
            | ""                | "abc_123"      | "Epic sadface: Username is required"                                        |
            | "any_user456"     | ""             | "Epic sadface: Password is required"                                        |
            | "any_user456"     | "abc_123"      | "Epic sadface: Username and password do not match any user in this service" |
            | "locked_out_user" | "secret_sauce" | "Epic sadface: Sorry, this user has been locked out."                       |
            | " standard_user"  | "abc_123"      | "Epic sadface: Username and password do not match any user in this service" |
            | "standard_user "  | "abc_123"      | "Epic sadface: Username and password do not match any user in this service" |
            | "standard_user"   | " "            | "Epic sadface: Username and password do not match any user in this service" |
            | " "               | "secret_sauce" | "Epic sadface: Username and password do not match any user in this service" |
    
    @forms @regression
    Scenario Outline: Login with valid credentials
        When user logs in with username <username> and the common password
        Then verify that the Products page appears with the correct title
        Examples:
            | username                  |
            | "standard_user"           |
            | "problem_user"            |
            | "performance_glitch_user" |
            | "error_user"              |
            | "visual_user"             |