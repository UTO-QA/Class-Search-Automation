package edu.asu.classsearch.testrunner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.*;
@RunWith(Cucumber.class)

@CucumberOptions(features={"resources/features/Combination.feature"},
								glue="edu.asu.classsearch.testcases.def",
									format = { "pretty","json:C:/Users/bsampat5/Selenium_Reports/cucumber.json" })
public class ClassSearchTestsWithReport {
	
}
