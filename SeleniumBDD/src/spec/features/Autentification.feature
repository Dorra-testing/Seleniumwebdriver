@authentification
Feature: authentification
  en tant qu 'un administrateur je veux m authentifier sur l application orangeHRM

  @authentificationValide
  Scenario: authentification avec des coordonnes valide
    Given je me connecte sur l'application
    When je saisis le username "Admin"
    When je saisis le password "admin123"
    When je clique sur le boutton login
    Then je me rederige vers la page accueill et "Dashboard" s affiche
