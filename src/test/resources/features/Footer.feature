@footer
Feature: Footer

  Background:
    Given normal user logs in and gets to the Products page

  @checkUI
  Scenario: Verify Footer UI
    Then verify that the Footer elements are correctly displayed and enabled

 Scenario Outline: Verify the URLs of social networks
    Then verify that the URL for <social-network> is <url>
    Examples:
      | social-network | url                                            |
      | "Twitter"      | "https://twitter.com/saucelabs"                |
      | "Facebook"     | "https://www.facebook.com/saucelabs"           |
      | "LinkedIn"     | "https://www.linkedin.com/company/sauce-labs/" |
