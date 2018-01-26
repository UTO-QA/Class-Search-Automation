Feature: Generate Statistics

	Scenario: TC_47 Verify Filter Search Criteria with Filter By Location to test for Thunderbird location
		Given The user is on Class Search page Filter Search
		When User performs a search with subject and applies Location filter
		Then Results should return for locations matching the filter other locations do not return results
		
	