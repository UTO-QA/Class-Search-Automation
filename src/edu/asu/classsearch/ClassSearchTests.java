package edu.asu.classsearch;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.hamcrest.CoreMatchers;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import java.util.regex.*;

public class ClassSearchTests {
	private static classsearchAutomation automate;
  @BeforeClass
  public static void setup(){
	 automate=new classsearchAutomation();
	  automate.getconnection();
  }
  @Test
  public void test_positive_course() throws Exception {
    String verify=automate.test_subject();
    assertThat(verify,CoreMatchers.containsString("Showing"));
  }
  @Test
  public void test_negative_course() throws Exception {
	  String verify=automate.test_subject1();
	    assertEquals(verify, "Please update your search criteria and try again.");
  }
  @Test
  public void test_positive_course_number() throws Exception {
	  String verify=automate.test_subject_number();
	  assertThat(verify,CoreMatchers.containsString("Showing"));
  }
  @Test
  public void test_negative_course_number() throws Exception {
	  String verify=automate.test_subject1_number();
	    assertEquals(verify, "Please update your search criteria and try again.");
  }
  @Test
  public void test_negative_course_negative_number() throws Exception {
	  String verify=automate.test_subject1_number();
	    assertEquals(verify, "Please update your search criteria and try again.");
  }
  @AfterClass
  public static void tearDown() throws Exception {
	  automate.closeconnection();
  }
  }

 