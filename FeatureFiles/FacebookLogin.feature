Feature: Facebook Login page

  Scenario: validate facebook login page with DataProvider concept
   
    When configure "user" & "pass" with DataProvider concept 
    Then refresh page
