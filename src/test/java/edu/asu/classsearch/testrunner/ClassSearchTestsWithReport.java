package edu.asu.classsearch.testrunner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.*;

@RunWith(Cucumber.class)

@CucumberOptions(features = { "src/test/resources/features/CC-941.feature"/*,
		"src/test/resources/features/sprint2.feature", "src/test/resources/features/Advanced Search.feature",
		"src/test/resources/features/Keyword Search.feature",
		"src/test/resources/features/Filter Search.feature"*/ }, glue = "edu.asu.classsearch.testcases.def", format = {
				"pretty", "json:C:/Users/bsampat5/Selenium_Reports/cucumber.json" })
public class ClassSearchTestsWithReport {

}