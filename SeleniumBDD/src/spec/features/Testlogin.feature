@Testlogin
Feature: Login to the application

  @TestloginValide
  Scenario: TestloginValide
  Given I visit the login page
  When I enter my Username "student"
  And I enter my Password "Password123"  
  And I click on the button Submit 
  Then I will be redirected to HOME page and "HOME" s affiche
