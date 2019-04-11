Feature: Generate Statistics
    Scenario: TC_60 Verify Filter Search Criteria with Filter By Location and without subject
        Given The user is on Class Search page Filter Search prod
        Then Results should return for locations matching the filter current having size
