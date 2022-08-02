Feature: user should be able to log to the system

  Background: user open browser and go to login page
    Given user open browser
    And user navigates to login page

#Test Scenario 1:
Scenario: user login with valid username and password

  #actions
  When user enter username and password "tomsmith" and "SuperSecretPassword!"
  #logical action between above an below statements
  And user click on login button
  #Expected Result
  Then user could login successfully
  And user go to home page

#test scenario 2
  Scenario: user login with invalid username and password

    When user enter username and password "tom" and "Super"
    And user click on login button
    Then user could not login
