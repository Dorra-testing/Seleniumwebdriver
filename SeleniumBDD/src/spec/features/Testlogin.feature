@Testlogin
Feature: Login to the application

  @TestloginValide
  Scenario: TestloginValide
    Given I visit the login page
    When I enter my Username "student"
    And I enter my Password "Password123"
    And I click on the button Submit
    Then I will be redirected to HOME page and "HOME" s affiche

  @TestloginInValide
  Scenario Outline: authentification avec des coordonnes invalide
    Given I visit the login page
    When I enter my Username "<Username>"
    And I enter my Password "<Password>"
    And I click on the button Submit
    Then I will receive the following message "<ExpectedMessage>" s affiche

    Examples:
      | Username | Password     | ExpectedMessage           |
      | student  | Password1234 | Your password is invalid! |
      | studen   | Password123  | Your username is invalid! |
