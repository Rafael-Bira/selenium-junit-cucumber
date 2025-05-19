@cart
Feature: Cart page

    Background:
        Given normal user logs in and gets to the Products page

    @checkUI
    Scenario: Verify Cart page UI
        When user clicks the cart button
        Then verify that the Cart page elements are enabled and correctly displayed
    
    @regression
    Scenario: Add items to the cart and verify that they are correctly displayed at the Cart page
        When user clicks on the first Add to cart button
        And user clicks the cart button
        Then verify that the item elements are correctly displayed

    Scenario: Verify that the Continue Shopping button navigates back to Products page
        When user clicks the cart button
        And clicks the Continue Shopping button
        Then verify that the Products page appears with the correct title

    Scenario: Verify that the Remove button of the first item really removes it
        When user clicks every Add to cart button
        And user clicks the cart button
        And clicks the Remove button of the first item
        Then verify that now the name of the first item is different
