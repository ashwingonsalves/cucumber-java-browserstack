Feature: Search Wikipedia

  Scenario: Finding Cucumber
    Given Enter search term 'Cucumber'
    When Do search
    Then Single result is shown for 'Cucumber'
