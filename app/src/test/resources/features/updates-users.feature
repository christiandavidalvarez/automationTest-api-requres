Feature: Updating user information
  As an API user
  Mario want to be able to update an existing users information

  Scenario: Successful update of a users job
    Given Mario have access to modify a specific user
    When he update this users occupation
    Then the system should confirm the update
    And the updated information should be reflected in the users data