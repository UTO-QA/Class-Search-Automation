package edu.asu.classsearch.testcases.def;
import org.hamcrest.MatcherAssert;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import edu.asu.classsearch.pages.*;

public class classearch_crosspage_functionalities {
	private Loginpage page;
	private classearch_page1 peoplesoft_1;
	private classearch_page2 peoplesoft_2;
	private classearch_finalpage peoplesoft_3;
	//TEST 19
	@Given("^User is on ClassSearch Homepage$")
	public void accesspage(){
	WebDriver driver=classearch_commons.getconn();
	classearch_HomePage_Methods cl=new classearch_HomePage_Methods(driver);}
	@When("^A user adds a class from class catalog$")
	public void addcourse(){
		WebDriver driver=classearch_commons.getconn();
		classearch_HomePage_Methods cl=new classearch_HomePage_Methods(driver);
		cl.check_ifopenorall("open");
		cl.subjectandnumber("CSE","539");
		cl.performsearch();
		cl.addcourse();
		page=new Loginpage(driver);
		page.get_login();
		peoplesoft_1=new classearch_page1(driver);
		peoplesoft_1.select_frame();
		//peoplesoft_1.select_an_instructor();
		peoplesoft_1.navigate_next();
		peoplesoft_2=new classearch_page2(driver);
		peoplesoft_2.select_frame();
		peoplesoft_2.navigate_proceed_step_2of3();
		peoplesoft_3=new classearch_finalpage(driver);
		peoplesoft_3.select_frame();
		peoplesoft_3.navigate_finishenrolling();
	}
	@Then("^The class should be added succesfully to their schedule$")
	public void verify_addedclass(){
		String actual=peoplesoft_3.verify_added();
		Assert.assertEquals("Success: This class has been added to your schedule.".trim(),actual.trim() );
	}
}
