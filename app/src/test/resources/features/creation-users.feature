Feature: Registering new users
  As an API user
  I want to be able to register new users by specifying their name and occupation

  Scenario: Successful registration of a new user
    Given I have valid information for a new user
    When I register this new user in the system
    Then the system should confirm the creation of the user
    And provide me with information such as the ID and creation date