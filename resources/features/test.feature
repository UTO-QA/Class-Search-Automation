Feature: Test Feature

	Scenario: TC_50 Verify Filter Search Criteria with Filter by Days of Week
		Given The user is on Class Search page Filter Search
		When User performs a search with School and applies Days filter
		Then Results should return any class with any day in the filter set