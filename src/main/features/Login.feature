Feature: user should be able to log to the system

#Test Scenario:
Scenario: user login with valid username and password
  #pre-request
  Given user open browser
  And user navigates to login page
  #actions
  When user enter username and password "tomsmith" and "SuperSecretPassword!"
  #logical action between above an below statements
  And user click on login button
  #Expected Result
  Then user could login successfully
  And user go to home page
  And user close browser


  Scenario: user login with invalid username and password
    Given user open browser
    And user navigates to login page
    When user enter username and password "tom" and "Super"
    And user click on login button
    Then user could not login
    And user close browser
