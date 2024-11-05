Feature: Login feature

  Scenario: Login Happy Path
    Given I open Login Page
    When I enter email "natalia.kalinina@testpro.io"
    And I enter password "nkKoel24$"
    And I submit
    Then I am logged in