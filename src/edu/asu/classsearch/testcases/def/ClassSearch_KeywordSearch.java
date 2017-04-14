package edu.asu.classsearch.testcases.def;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.WebDriver;

import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import edu.asu.classsearch.input.get_Input;
import edu.asu.classsearch.pages.ClassSearchResults_Validator;
import edu.asu.classsearch.pages.ClassSearch_AdvancedSearch;
import edu.asu.classsearch.pages.classearch_HomePage_Methods;
import edu.asu.classsearch.pages.classearch_commons;

public class ClassSearch_KeywordSearch {

	WebDriver driver;
	classearch_HomePage_Methods home;
	ClassSearchResults_Validator val;
	String validateString[];
	String results;
	String testCase;
	
	@Before
	public void before(Scenario scenario) {
	    String scenarioName=scenario.getName();
	    this.testCase=scenarioName.substring(0,scenarioName.indexOf(" "));
	}
	
	@Given("^The user is on Class Search page to search using Keyword$")
	public void getconnection(){
		driver=classearch_commons.getconn("https://webapp4-dev.asu.edu/elastic-catalog/");
		
		val=new ClassSearchResults_Validator(driver);
		home=new classearch_HomePage_Methods(driver);
	}
	
	//Search By keyword testcases
	@When("^User performs a search using Search by Keyword$")
	public void positive_Keyword_3CharSearch_Subject(){

		String []values=get_Input.inputload(testCase).split(",");
		String subject=values[0];
		this.validateString=new String[1];
		this.validateString[0]=subject;
		
		home.keyword(subject);
		home.performsearch();
		
		this.results=home.assertresults();
 

	}
	
	@Then("^The Results must contain records with matching subject$")
	public void validate_3CharSearch_Subject(){
		//Validate Subject Details and Instructor Details
		val.validateSubjectName(validateString[0]);
		MatcherAssert.assertThat(results,CoreMatchers.containsString("Showing"));
		//TODO: how to check subject is correct.	
		driver.quit();
	}
	
	
	@Then("^The Results must contain records with matching class title/topic title or instructor$")
	public void validate_3CharSearch_ClassTitle(){
		//Validate Subject Details and Instructor Details
		val.validateClassTitleAndIns(validateString[0]);
		MatcherAssert.assertThat(results,CoreMatchers.containsString("Showing"));
		driver.quit();
	}

	
	@Then("^The Results must contain records with correct subject and category number$")
	public void validate_SubjectNumber(){
		//Validate Subject Details and Instructor Details
		val.validateSubjectName(validateString[0]);
		MatcherAssert.assertThat(results,CoreMatchers.containsString("Showing"));	
		driver.quit();
	}

	
	@Then("^The Results must contain records that match the class number$")
	public void validate_ClassNumber(){
		//Validate Subject Details and Instructor Details
		val.validateClassNumber(validateString[0]);
		MatcherAssert.assertThat(results,CoreMatchers.containsString("Showing"));	
		driver.quit();
	}
	
	@Then("^The Results must contain records that match the class number and ignores all other keywords$")
	public void validate_ClassNumberIgnore(){
		//Validate Subject Details and Instructor Details
		val.validateClassNumber(validateString[0].split(" ")[1]);
		MatcherAssert.assertThat(results,CoreMatchers.containsString("Showing"));	
		driver.quit();
	}
	
	@Then("^The Results must contain subjects that match the formal description$")
	public void validate_SubjectDescription(){
		//Validate Subject Details and Instructor Details
		
		//Compare the results with a new search that  matches the Subject formal description
		WebDriver driver2=classearch_commons.getconn("https://webapp4-dev.asu.edu/elastic-catalog/");
		String []values=get_Input.inputload(testCase).split(",");
		String subject=values[1];
		home=new classearch_HomePage_Methods(driver2);
		
		home.subject(subject);
		home.performsearch();
		
		val.verifyResultWithProd(driver2);
		driver2.quit();
		driver.quit();
	}
	
}
