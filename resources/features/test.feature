Feature: Test Feature

	Scenario: TC_35 Verify User performs any 3 character search that does not match subject table but matches class topic or instructor
		Given The user is on Class Search page to search using Keyword
		When User performs a search using Search by Keyword
		Then The Results must contain records with matching class title/topic title or instructor
						
	Scenario: TC_36 Verify User performs search in the format 'ENG 101'
		Given The user is on Class Search page to search using Keyword
		When User performs a search using Search by Keyword
		Then The Results must contain records with correct subject and category number
						
	Scenario: TC_39 Verify User performs keyword search with a keyword that matches formal subject description  
		Given The user is on Class Search page to search using Keyword
		When User performs a search using Search by Keyword
		Then The Results must contain subjects that match the formal description