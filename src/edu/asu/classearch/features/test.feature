Feature: Class Search verify Keyword Search criteria
	Scenario: TC_38 Verify User performs keyword search that includes 5 digits 
		Given The user is on Class Search page to search using Keyword
		When User performs a search using Search by Keyword
		Then The Results must contain records that match the class number and ignores all other keywords		