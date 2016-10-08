Feature: Class Search verify Subject,Number and keyword

	Scenario: Verify User provides correct Subject 
		Given The user is on Class Search page 
		And User enters Correct Subject
		Then The Results should be Displayed
		
	 Scenario: Verify User provides Incorrect Subject 
		Given The user is on Class Search page 
		And User enters Incorrect Subject
		Then The Warning should be Displayed
		
	