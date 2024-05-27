Feature: Login feature

  Background:
    #Given user is navigated to HRMS application
  @smoke @sprint1
  Scenario: Valid admin login
    * user enters valid admin username and password
    * user clicks on login button
    * admin user is successfully logged in


  Scenario: Valid ess login
    When user enters valid ess username and password
    And user clicks on login button
    Then admin user is successfully logged in