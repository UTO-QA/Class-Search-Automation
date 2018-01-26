Feature: Test that takes any Combination of Inputs and Compares two environments

    Scenario: TC_52 Verify Filter Search Criteria with Filter By Location to test for Cochise location
    Given The user is on Class Search page Filter Search prod
    When User performs a search with subject and applies Location filter current
    Then Results should return for locations matching the filter current

    Scenario: TC_53 Verify Filter Search Criteria with Filter By Location to test for Central AZ College location
    Given The user is on Class Search page Filter Search prod
    When User performs a search with subject and applies Location filter current
    Then Results should return for locations matching the filter current

    Scenario: TC_54 Verify Filter Search Criteria with Filter By Location to test for Lake Havasu location
    Given The user is on Class Search page Filter Search prod
    When User performs a search with subject and applies Location filter current
    Then Results should return for locations matching the filter current