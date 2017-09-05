Feature: Test Feature

		
	Scenario: TC_30 Verify user searches using General Studies option only classes with the chosen GS category should return
		Given The user is on Class Search page Advanced Search
		When  User performs a search using General Studies option
		Then The Results must display only classes with the chosen GS category		
