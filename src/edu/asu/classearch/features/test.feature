Feature: Class Search verify Radio buttons open-all,inperson-online and session checkbox

			
	Scenario: TC_30 Verify user searchs using General Studies option only classes with the chosen GS category should return
		Given The user is on Class Search page Advanced Search
		When  User performs a search using General Studies option
		Then The Results must display only classes with the chosen GS category