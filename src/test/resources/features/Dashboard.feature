Feature: Dashboard functionality
  #this type of DataTable is applicable when we volume of data is small.
  @dashboard
  Scenario: verify dashboard tabs
    When user enters valid admin username and password
    And user clicks on login button
    Then admin user is successfully logged in
    Then verify all the dashboard tabs
      | Admin         |
      | PIM           |
      | Configuration |
      | Employee List |
      | Add Employee  |
      | Reports       |
      | Leave         |
      | Time          |
      | Recruitment   |
      | Performance   |
      | Dashboard     |
      | Directory     |