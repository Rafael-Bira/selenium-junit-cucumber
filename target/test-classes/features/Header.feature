@header
Feature: Header
    
    Background: 
        Given normal user logs in and gets to the Products page

    @checkUI
    Scenario: Verify Header UI
        Then verify that the Header elements are correctly displayed and enabled