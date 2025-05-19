@burgerMenu
Feature: Burger Menu

    Background:
        Given normal user logs in and gets to the Products page
        And user clicks the Burger Menu button

    @checkUI
    Scenario: Verify Burger Menu UI
        Then verify that the Burger Menu links are displayed and enabled
    
    Scenario: Verify About link
        Then verify that the About link has the URL "https://saucelabs.com/"
    
    Scenario: Verify Logout link
        When user clicks on Logout link
        Then verify that the Login page appears with the correct title
    
    Scenario: Verify Reset App State link
        When user clicks on Reset App State link
        Then the cart icon has no items