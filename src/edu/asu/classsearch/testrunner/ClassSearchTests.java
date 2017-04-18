package edu.asu.classsearch.testrunner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.*;
@RunWith(Cucumber.class)
@CucumberOptions(features="src/edu/asu/classearch/features/Keyword Search.feature",glue="edu.asu.classsearch.testcases.def",plugin = {"html:target"})
public class ClassSearchTests {
	
  }

 