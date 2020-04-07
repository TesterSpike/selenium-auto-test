Feature: Add a note

  Scenario: As a user I want to be able to add a simple note
    Given I am a user adding a note
    When I enter a simple note
    Then I will see that my note has been added

  Scenario: As a user I want to be able to add a complex note
    Given I am a user adding a note
    When I enter a complex note
    Then I will see that my note has been added