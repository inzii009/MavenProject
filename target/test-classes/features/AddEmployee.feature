Feature: Add Employee
  @regression
  Scenario: Adding one employee from feature file
    When user enters valid admin username and password
    And user clicks on login button
    Then admin user is successfully logged in
    When user clicks on PIM option
    And user clicks on Add employee button
    And user enters firstname and lastname
    And user clicks on save button
    Then employee added successfully

