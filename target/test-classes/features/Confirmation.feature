@confirmation
Feature: Confirmation page

    Background:
        Given the user must have gotten to the Overview page and confirmed the purchase
    
    @checkUI
    Scenario: Verify Confirmation page UI
        Then verify that the Confirmation page elements are correctly displayed and enabled

    Scenario: Verify that the Back Home button navigates back to the Products page
        When user clicks the Back Home button
        Then verify that the Products page appears with the correct title