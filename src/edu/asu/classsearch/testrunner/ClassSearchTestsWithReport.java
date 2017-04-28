package edu.asu.classsearch.testrunner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.*;
@RunWith(Cucumber.class)
@CucumberOptions(features={"src/edu/asu/classearch/features/test.feature","src/edu/asu/classearch/features/test.feature"},
								glue="edu.asu.classsearch.testcases.def",
									format = { "pretty","json:C:/Users/udasu/Dropbox (ASU)/automation/Reports/cucumber.json" })
public class ClassSearchTestsWithReport {
	
}

 