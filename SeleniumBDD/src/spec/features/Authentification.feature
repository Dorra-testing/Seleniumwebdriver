@authentification
Feature: authentification
  en tant qu 'un administrateur je veux m authentifier sur l application orangeHRM

  @authentificationValide
  Scenario: authentification avec des coordonnes valide
    Given je me connecte sur l'application
    When je saisis mon email "dorra@gmail.com"
    And je saisis le password "dorra123"
    And je clique sur le boutton login
    Then je me rederige vers la page accueill et "Log out" s affiche
    
    
