@automationexercise
Feature: Login to the application

  @ValidSearch
  Scenario: ValidSearch
  Given I visit the automation exercise page
  When I enter my Search store "polo"
  And I click on the button Search
  Then I see "Premium Polo T-Shirts"
