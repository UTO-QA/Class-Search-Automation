package edu.asu.classsearch.testrunner;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import static org.hamcrest.MatcherAssert.assertThat;
import org.hamcrest.CoreMatchers;
import org.junit.*;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.*;
import edu.asu.classsearch.testcases.def.classsearch_Homepage_Automation;

import java.util.regex.*;
@RunWith(Cucumber.class)
@CucumberOptions(features="src/edu/asu/classearch/features/sprint2.feature",glue="edu.asu.classsearch.testcases.def",format = {"html:target"})
public class ClassSearchTests {
	
  }

 