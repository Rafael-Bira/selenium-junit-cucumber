@overview
Feature: Overview page

    Background:
        Given user has added all items, completed the checkout form and proceeded to the Overview page

    @checkUI
    Scenario: Verify Overview page UI
        Then verify that the Overview page elements are correctly displayed and enabled

    @regression
    Scenario: Verify that the Item Total and Total sums are correct
        When user sums all prices of the items
        Then verify that the Item total and Total values are correct

    Scenario: Verify that the item link navigates to the Item Detail page and the names are the same
        When user clicks on the first item name
        Then verify that the item name is the same

    Scenario: Verify that the Cancel button returns to Products page
        When user clicks the Overview Cancel button
        Then verify that the Products page appears with the correct title