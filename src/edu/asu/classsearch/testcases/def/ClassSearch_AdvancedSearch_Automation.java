package edu.asu.classsearch.testcases.def;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import edu.asu.classsearch.pages.ClassSearch_AdvancedSearch;
import edu.asu.classsearch.pages.classearch_HomePage_Methods;
import edu.asu.classsearch.pages.classearch_commons;
import edu.classsearch.input.get_Input;
import edu.asu.classsearch.pages.ClassSearchResults_Validator;;

public class ClassSearch_AdvancedSearch_Automation {
	
	private ClassSearchResults_Validator val;
	private WebDriver driver;
	private ClassSearch_AdvancedSearch adv;
	private classearch_HomePage_Methods home;
	private String validateString[];
	private String results="";

	//creates a connection
	@Given("^The user is on Class Search page Advanced Search$")
	public void getconnection(){
		driver=classearch_commons.getconn();
		adv=new ClassSearch_AdvancedSearch(driver);
		val=new ClassSearchResults_Validator(driver);
		home=new classearch_HomePage_Methods(driver);
	}
	
	//22: User Enters correct subject and instructor 
	@When("^User performs a search using the correct Subject and Instructor$")
	public void Postive1_subject(){
		String []values=get_Input.inputload("TC_22").split(",");
		String subject=values[0];
		String instructor=values[1];
		validateString=new String[2];
		validateString[0]=subject;
		validateString[1]=instructor;
		home.subject(subject);
		adv.clickAdvancedSearch();
		adv.enterInstructorName(instructor);
		home.performsearch();
	  this.results=home.assertresults();

	}
	@Then("^The Results with correct subject info and Instructor should be Displayed$")
	public void test_Positive1_subject(){
		//Validate Subject Details and Instructor Details
		val.validateSubjectName(validateString[0]);
		val.validateInstructorName(validateString[1]);
		val.validateEndDate("12/01");
		MatcherAssert.assertThat(results,CoreMatchers.containsString("Showing"));
		driver.quit();
		
	}

}
