Feature: user should be able to log to the system

#Test Scenario:
Scenario: user login with valid username and password
  #pre-request
  Given user open browser
  And user navigates to login page
  #actions
  When user enter valid username and password
  #logical action between above an below statements
  And user click on login button
  #Expected Result
  Then user could login successfully
  And user go to home page


  Scenario: user login with invalid username and password