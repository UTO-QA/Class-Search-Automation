package edu.asu.classsearch.testrunner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.*;
@RunWith(Cucumber.class)
@CucumberOptions(features={"src/edu/asu/classearch/features/test.feature"},glue="edu.asu.classsearch.testcases.def",format = {"html:target"})
public class ClassSearchDualRun {
	
  }


 