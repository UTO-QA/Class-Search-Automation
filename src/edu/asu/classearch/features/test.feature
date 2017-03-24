Feature: Class Search verify Radio buttons open-all,inperson-online and session checkbox

Scenario: TC_19 Verify that the results displayed contain only Session C classes when session C is selected 
		Given User is on ClassSearch Homepage
		When A user adds a class for testing addition from class catalog
		Then The class should be added succesfully to their schedule