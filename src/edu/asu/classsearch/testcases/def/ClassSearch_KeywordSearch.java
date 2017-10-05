package edu.asu.classsearch.testcases.def;

import org.openqa.selenium.WebDriver;

import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import edu.asu.classsearch.driver.ClassSearchDriver;
import edu.asu.classsearch.input.ClassSearchInputOLD;
import edu.asu.classsearch.pages.ClassSearchResultsValidator;
import edu.asu.classsearch.pages.classearch_HomePage_Methods;

public class ClassSearch_KeywordSearch {

	WebDriver driver, prodDriver;
	classearch_HomePage_Methods home, prodHome;
	ClassSearchResultsValidator val;
	String validateString[];
	String results;
	String testCase;

	@Before
	public void before(Scenario scenario) {
		String scenarioName = scenario.getName();
		this.testCase = scenarioName.substring(0, scenarioName.indexOf(" "));
	}

	@Given("^The user is on Class Search page to search using Keyword$")
	public void getconnection() {
		driver = ClassSearchDriver.getDriver("https://webapp4-dev.asu.edu/elastic-catalog/");
		prodDriver = ClassSearchDriver.getDriver("https://webapp4-dev.asu.edu/catalog/");

		val = new ClassSearchResultsValidator(driver);
		home = new classearch_HomePage_Methods(driver);
		prodHome = new classearch_HomePage_Methods(prodDriver);
	}

	// Search By keyword testcases
	@When("^User performs a search using Search by Keyword$")
	public void positive_Keyword_3CharSearch_Subject() {

		String[] values = ClassSearchInputOLD.inputload(testCase).split(",");
		String subject = values[0];
		this.validateString = new String[1];
		this.validateString[0] = subject;

		home.keyword(subject);
		home.performsearch();

		prodHome.keyword(subject);
		prodHome.performsearch();

	}

	@Then("^The Results must contain records with matching subject$")
	public void validate_3CharSearch_Subject() {
		// Validate Subject Details and Instructor Details
		val.validateSubjectNumber(validateString[0]);
		val.verifyResultWithProd(prodDriver);
		// MatcherAssert.assertThat(results,CoreMatchers.containsString("Showing"));
		// TODO: how to check subject is correct.

	}

	@Then("^The Results must contain records with matching class title/topic title or instructor$")
	public void validate_3CharSearch_ClassTitle() {
		// Validate Subject Details and Instructor Details
		// val.validateClassTitleAndIns(validateString[0]);
		// MatcherAssert.assertThat(results,CoreMatchers.containsString("Showing"));
		val.verifyResultWithProd(prodDriver);

	}

	@Then("^The Results must contain records with correct subject and category number$")
	public void validate_SubjectNumber() {
		// Validate Subject Details and Instructor Details
		// val.validateSubjectName(validateString[0]);
		// MatcherAssert.assertThat(results,CoreMatchers.containsString("Showing"));
		val.verifyResultWithProd(prodDriver);
		// MatcherAssert.assertThat(results,CoreMatchers.containsString("Showing"));
		// TODO: how to check subject is correct.

	}

	@Then("^The Results must contain records that match the class number$")
	public void validate_ClassNumber() {
		// Validate Subject Details and Instructor Details
		// val.validateClassNumber(validateString[0]);
		// MatcherAssert.assertThat(results,CoreMatchers.containsString("Showing"));
		val.verifyResultWithProd(prodDriver);
		// MatcherAssert.assertThat(results,CoreMatchers.containsString("Showing"));
		// TODO: how to check subject is correct.

	}

	@Then("^The Results must contain records that match the class number and ignores all other keywords$")
	public void validate_ClassNumberIgnore() {
		// Validate Subject Details and Instructor Details
		// val.validateClassNumber(validateString[0].split(" ")[1]);
		// MatcherAssert.assertThat(results,CoreMatchers.containsString("Showing"));
		val.verifyResultWithProd(prodDriver);
		// MatcherAssert.assertThat(results,CoreMatchers.containsString("Showing"));
		// TODO: how to check subject is correct.

	}

	@Then("^The Results must contain subjects that match the formal description$")
	public void validate_SubjectDescription() {
		// Validate Subject Details and Instructor Details

		// Compare the results with a new search that matches the Subject formal
		// description
		WebDriver driver2 = ClassSearchDriver.getDriver("https://webapp4-dev.asu.edu/elastic-catalog");
		String[] values = ClassSearchInputOLD.inputload(testCase).split(",");
		String subject = values[1];
		home = new classearch_HomePage_Methods(driver2);

		home.subject(subject);
		home.performsearch();

		val.verifyResultWithProd(driver2);
		driver2.quit();

		val.verifyResultWithProd(prodDriver);
		// MatcherAssert.assertThat(results,CoreMatchers.containsString("Showing"));
		// TODO: how to check subject is correct.

	}

}
