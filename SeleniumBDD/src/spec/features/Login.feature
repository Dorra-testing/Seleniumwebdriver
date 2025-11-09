@Login
Feature: Login to Demo Web Shop

  @ValidLogin
  Scenario: Login with correct credentials
    Given I open the application
    When I enter the email "dorra@gmail.com"
    And I enter the password "dorra123"
    And je_clique_sur_le_boutton_login
    Then I should be redirected to the URL "https://demowebshop.tricentis.com/"

