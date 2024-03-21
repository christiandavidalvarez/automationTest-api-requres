Feature: Deleting users
  As an API user
  I want to be able to delete an existing user

  Scenario: Successful deletion of a user by ID
    Given I have the ID of a user I wish to delete
    When I request the deletion of this user
    Then the system should confirm the deletion
    And the user should no longer exist in the system