Feature: Add Employee

  Background:
    When user enters valid admin username and password
    And user clicks on login button
    Then admin user is successfully logged in
    When user clicks on PIM option
    And user clicks on Add employee button

  @regression
  Scenario: Adding one employee from feature file
    And user enters firstname and lastname
    And user clicks on save button
    Then employee added successfully

  @ddt
  Scenario Outline: Add employee
    And user enters "<firstName>" "<middleName>" and "<lastName>"
    And user clicks on save button
    Then employee added successfully

    Examples:
    |firstName|middleName|lastName|
    | txt123  |    txt   | txt321 |
    | txt456  |    txt   | txt645 |
    | txt789  |    txt   | txt998 |

    @cucumber
    Scenario: Adding one employee using cucumber feature
      And user enters direct data "AnayaFM" "NMN" and "Eugeine"
      And user clicks on save button
      Then employee added successfully

    @datatable
    Scenario: Add employee
      When user add multiple employees and verify they are added
      |firstName|middleName|lastName|
      | tx123  |    txt   | txt321 |
      | tx456  |    txt   | txt645 |
      | tx789  |    txt   | txt998 |

     @excel
      Scenario: Adding employees from excel file
        When user adds multiple employees from excel file using "EmployeeData" sheet and verify the added employees