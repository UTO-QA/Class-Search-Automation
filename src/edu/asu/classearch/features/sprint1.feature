Feature: Class Search verify Subject,Number and keyword

	Scenario: TC_1 Verify User provides correct Subject 
		Given The user is on Class Search page 
		When User enters Correct Subject
		Then The Results with correct subject info should be Displayed
		
	 Scenario: TC_2 Verify User provides Incorrect Subject 
		Given The user is on Class Search page 
		When User enters Incorrect Subject
		Then A Warning should be Displayed for incorrect subject
				
	Scenario: TC_3 Verify User provides Correct Subject and Number
		Given The user is on Class Search page 
		When User enters correct Subject and Number
		Then The Results should be Displayed for Correct Subject and Number scenario
		
	Scenario: TC_4 Verify User provides Incorrect Subject and Number
		Given The user is on Class Search page 
		When User enters incorrect Subject and incorrect Number
		Then A Warning should be Displayed for incorrect subject and number scenario
	
	Scenario: TC_5 Verify User provides Incorrect Subject and Number
		Given The user is on Class Search page 
		When User enters swapped values for Subject and Number
		Then A Warning should be Displayed for swapped scenario
		
    Scenario: TC_6 Verify User provides only a correct Number
		Given The user is on Class Search page 
		When User enters correct Number
		Then  A Warning should be Displayed for correct Number Scenario
		
	Scenario: TC_7 Verify a warning is displayed when user enters only number which is incorrect 
		Given The user is on Class Search page 
		When User enters incorrect Number
		Then  A Warning should be Displayed for incorrect number scenario
		
	Scenario: TC_8 Verify the user is able to perform the search succesfully using a correct  keyword 
		Given The user is on Class Search page 
		When  User performs a search using only the correct keyword
		Then  The search results page is displayed for correct keyword scenario
		
		
	Scenario: TC_9 Verify that search with only incorrect keyword produces proper warning message
		Given The user is on Class Search page 
		When  User performs a search using only the incorrect keyword or keyword with less than 3 letters
		Then  An Appropriate warning message is displayed for incorrect keyword
		
	Scenario: TC_10 Verify that search with correct Subject and keyword produces Search Results
		Given The user is on Class Search page 
		When  User performs a search using the correct keyword and correct Subject
		Then  The Search Results page is Displayed for correct keyword and subject scenario
		
	Scenario: TC_11 Verify that search with incorrect Subject or keyword produces a warning
		Given The user is on Class Search page 
		When  User performs a search using the incorrect keyword or Subject
		Then  The Warning is Displayed for incorrect keyword or subject scenario
	
Scenario: TC_12 Verify that the results displayed for open classes only when open is selected
		Given The user is on Class Search page 
		When User selects for open classes and performs a search
		Then The Results should only contain open values
		
	Scenario: TC_13 Verify that the results displayed for open and closed classes only when all is selected
		Given The user is on Class Search page 
		When User selects for all classes and performs a search
		Then The Results should contain open and closed values
		
	Scenario: TC_14 Verify that the results displayed contain only campus classes when in-Person is selected
		Given The user is on Class Search page 
		When User selects for in-person and performs a search
		Then The Results should contain only On-Campus Classes
		
	Scenario: TC_15 Verify that the results displayed contain only ASUONLINE classes when online is selected
		Given The user is on Class Search page 
		When User selects for online and performs a search
		Then The Results should contain only online Classes
		
	Scenario: TC_16 Verify that the results displayed contain only Session A classes when session A is selected 
		Given The user is on Class Search page 
		When User selects Session A and performs a search
		Then The Results should contain only Session A classes
		
	Scenario: TC_17 Verify that the results displayed contain only Session B classes when session B is selected 
		Given The user is on Class Search page 
		When User selects Session B and performs a search
		Then The Results should contain only Session A classes
		
	Scenario: TC_18 Verify that the results displayed contain only Session C classes when session C is selected 
		Given The user is on Class Search page 
		When User selects Session C and performs a search
		Then The Results should contain only Session A classes
		