Feature: Login Feature
  Verify if user is able to Login in to the site

  @Ready
  Scenario Outline: Login with incorrect credentials
    Given user is on homepage
    And user navigates to "Login" Page
    When user fill username <username> and password <password>
    Then Error message is displayed
    Examples:
      |username  |password|
      |melbarrak|Test123|


  Scenario: Login with correct credentials
    Given user is on homepage
    And user navigates to "Login" Page
    When user fill username melbarrak and password Test123
    Then success message is displayed
