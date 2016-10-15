package edu.asu.classsearch.test;

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
import edu.asu.classsearch.classsearch_Homepage_Automation;
import java.util.regex.*;
@RunWith(Cucumber.class)
@CucumberOptions(features="src",glue="edu.asu.classsearch",format = {"html:target"})
public class ClassSearchTests {
	
  }

 