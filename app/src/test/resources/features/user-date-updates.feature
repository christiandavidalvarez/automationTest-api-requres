Feature: Updating user information
  As an API user
  I want to be able to update an existing user's information

  Scenario: Successful update of a user's job
    Given I have access to modify a specific user
    When I update this user's occupation
    Then the system should confirm the update
    And the updated information should be reflected in the user's data