@products
Feature: Products page

  Background:
    Given normal user logs in and gets to the Products page

  @checkUI
  Scenario: Verify Products Page UI
    Then verify that the Products page elements are correctly displayed and enabled

  Scenario: Add to cart button text changes when clicked
    When user clicks every Add to cart button
    Then verify that the button text changes to "Remove"

  Scenario: Add all items and check the number in the cart icon
    When user clicks every Add to cart button
    Then verify that the cart icon at the Header displays the number 6

  Scenario Outline: Sort items by name
    When user selects <option> from the Sort dropdown
    Then the first name is <firstName> and the last is <lastName>
    Examples:
      | option | firstName                           | lastName                            |
      | "az"   | "Sauce Labs Backpack"               | "Test.allTheThings() T-Shirt (Red)" |
      | "za"   | "Test.allTheThings() T-Shirt (Red)" | "Sauce Labs Backpack"               |

  Scenario Outline: Sort items by price
    When user selects <option> from the Sort dropdown
    Then the first price is <firstPrice> and the last is <lastPrice>
    Examples:
      | option | firstPrice | lastPrice |
      | "lohi" | "$7.99"    | "$49.99"  |
      | "hilo" | "$49.99"   | "$7.99"   |
