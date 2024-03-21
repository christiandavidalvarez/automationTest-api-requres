Feature: Retrieving users
  As an API user
  I want to be able to list available users

  Scenario: Listing users from a specific page
    Given there are registered users on the platform
    When I request the list of users from a specific page
    Then I should receive a list containing the users of that page
    And the current page information matches the requested one