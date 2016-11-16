package edu.asu.classsearch.testcases.def;
import org.hamcrest.MatcherAssert;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import edu.asu.classsearch.pages.*;
import edu.classsearch.input.get_Input;

public class classearch_crosspage_functionalities {
	private Loginpage page;
	private classearch_page1 peoplesoft_1;
	private classearch_page2 peoplesoft_2;
	private classearch_finalpage peoplesoft_3;
	private classearch_HomePage_Methods cl;
	private WebDriver driver;
	//TC_19 Verify that the results displayed contain only Session C classes when session C is selected
	@Given("^User is on ClassSearch Homepage$")
	public void accesspage(){
	driver=classearch_commons.getconn();
	}
	@When("^A user adds a class from class catalog$")
	public void addcourse(){
		String []values=get_Input.inputload("TC_19").split(",");
		String openorall=values[0];
		String course=values[1];
		String number=values[2];
		cl=new classearch_HomePage_Methods(driver);
		cl.check_ifopenorall(openorall);
		cl.subjectandnumber(course,number);
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
		classearch_commons.closeconn();
	}
	//TC_20 
	@When("^A user swaps a class from class catalog$")
	public void swap(){
		String []values=get_Input.inputload("TC_20").split(",");
		String action=values[0];
		String coursenumber=values[1];
		cl=new classearch_HomePage_Methods(driver);
		cl.signIn();
		page=new Loginpage(driver);
		page.get_login();
		cl.Pregistrationaction(action).click();
		peoplesoft_1=new classearch_page1(driver);
		peoplesoft_1.select_frame();
		peoplesoft_1.select_a_course();
		peoplesoft_1.class_number(coursenumber);
		peoplesoft_1.action_enter();
		peoplesoft_1.navigate_next();
		peoplesoft_2=new classearch_page2(driver);
		peoplesoft_2.select_frame();
		peoplesoft_2.action_finishswapping();
	}
	@Then("^The class should be swapped succesfully to their schedule$")
	public void verify_swapclass(){
		peoplesoft_3=new classearch_finalpage(driver);
		peoplesoft_3.select_frame();
		String actual=peoplesoft_3.verify_added();
		Assert.assertEquals("Success: This class has been replaced.".trim(),actual.trim());
		classearch_commons.closeconn();
	}
	
}
