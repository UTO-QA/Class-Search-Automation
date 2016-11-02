Feature: Class Search verify Radio buttons open-all,inperson-online and session checkbox

	
		
	Scenario: TC_16 Verify that the results displayed contain only Session A classes when session A is selected 
		Given The user is on Class Search page 
		When User selects Session A and performs a search
		Then The Results should contain only Session A classes
		
	Scenario: TC_17 Verify that the results displayed contain only Session B classes when session A is selected 
		Given The user is on Class Search page 
		When User selects Session B and performs a search
		Then The Results should contain only Session A classes
		
	Scenario: TC_18 Verify that the results displayed contain only Session C classes when session A is selected 
		Given The user is on Class Search page 
		When User selects Session C and performs a search
		Then The Results should contain only Session A classes