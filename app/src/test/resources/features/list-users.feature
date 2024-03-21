Feature: Retrieving users
  As an API user
  Mario want to be able to list available users

  Scenario: Listing users from a specific page
    Given there are registered users on the platform
    When he request the list of users from a specific page
    Then he should receive a list containing the users of that page
    And the current page information matches the requested one