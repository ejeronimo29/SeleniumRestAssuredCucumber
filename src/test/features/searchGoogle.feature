Feature: Google search

Scenario: User searches for a keyword in Google
    Given User is on Google homepage
    When User enters "cucumber" in search bar
    And User clicks on search button
    Then Results for "cucumber" are displayed