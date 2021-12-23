Feature: Fb Login page 
  Scenario: verifying facebook details
    Given user is on the facebook page
    When user enter the username and password
    And user should clik login button
    Then user should verify success message
   
