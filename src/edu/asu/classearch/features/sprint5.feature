Feature: Class Search verify Keyword Search criteria
	
	Scenario: TC_33 Verify User performs any 3 character search that matches subject table
		Given The user is on Class Search page to search using Keyword
		When User performs a Search by Keyword with any 3 characters that matches subject table
		Then The Results must contain records with matching subject

	Scenario: TC_34 Verify User performs any 3 character search that does not match subject table but matches class topic or instructor
		Given The user is on Class Search page to search using Keyword
		When User performs a Search by Keyword with any 3 characters that do not match subject table but matches class topic or instructor
		Then The Results must contain records with matching class title/topic title or instructor
		
	Scenario: TC_35 Verify User performs any 3 character search that does not match subject table but matches class topic or instructor
		Given The user is on Class Search page to search using Keyword
		When User performs a Search by Keyword with any 3 characters that do not match subject table but matches class topic or instructor
		Then The Results must contain records with matching class title/topic title or instructor