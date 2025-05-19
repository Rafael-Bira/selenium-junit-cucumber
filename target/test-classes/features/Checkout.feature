@checkout
Feature: Checkout page

  Background:
    Given the user has logged in, added all items and get to the Checkout page

  @checkUI
  Scenario: Verify Checkout page UI
    Then verify that the Checkout page elements are correctly displayed and enabled

  Scenario: Verify that the Cancel button returns to Cart page
    When user clicks the Cancel button
    Then verify that the Cart page appears with the correct title

  @regression
  Scenario: Click the Continue button without filling any input
    Then user clicks the Continue button leaving all inputs empty

  @forms @regression
  Scenario Outline: Fill the form with incomplete data
    When user fills the form with <firstName>, <lastName> and <postalCode> and clicks the Continue button
    Then a message appears with the text <errorMessage>
    Examples:
      | firstName | lastName | postalCode | errorMessage                     |
      | ""        | ""       | ""         | "Error: First Name is required"  |
      | ""        | "Doe"    | "1234"     | "Error: First Name is required"  |
      | "John"    | ""       | "1234"     | "Error: Last Name is required"   |
      | "John"    | "Doe"    | ""         | "Error: Postal Code is required" |
      | ""        | ""       | "1234"     | "Error: First Name is required"  |
      | "John"    | ""       | ""         | "Error: Last Name is required"   |
      | ""        | "Doe"    | ""         | "Error: First Name is required"  |

  @forms @regression
  Scenario: Fill the form with valid data
    When user fills the form with "John", "Doe" and "1234" and clicks the Continue button
    Then the Overview page appears with the correct title