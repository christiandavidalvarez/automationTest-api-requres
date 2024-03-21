Feature: Registering new users
  As an API user
  Mario want to be able to register new users by specifying their name and occupation

  Scenario: Successful registration of a new user
    Given Mario have valid information for a new user
    When he register this new user in the system
    Then the system should confirm the creation of the user
    And provide it with information such as the ID and creation date