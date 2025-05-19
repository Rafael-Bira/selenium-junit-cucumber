@itemDetail
Feature: Item Detail page

    Background: 
        Given normal user logs in and gets to the Products page
        And goes to Item Detail page

    @checkUI
    Scenario: Verify Item Detail page UI
        Then verify that the Item Detail page elements are correctly displayed and enabled

    Scenario: Verify that the Back to products button returns to Products page
        When user clicks the Back to products button
        Then verify that the Products page appears with the correct title

    Scenario: Verify that the Add to cart button from Item Detail is the same as that of the Products page
        When user clicks the Add to cart button
        And user clicks the Back to products button
        Then the corresponding button text should be "Remove"