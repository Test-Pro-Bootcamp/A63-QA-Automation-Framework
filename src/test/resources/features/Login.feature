Feature: Login Feature
  Scenario: Login Positive Scenario
    Given  I open Koel page
    When I enter email "victoria.mereneanu@testpro.io"
    And I enter password "Testpro1234$"
    And I click submit
    Then i am logged in