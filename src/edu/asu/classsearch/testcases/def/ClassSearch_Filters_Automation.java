package edu.asu.classsearch.testcases.def;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.WebDriver;

import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import edu.asu.classearch.driver.ClassSearch_Driver;
import edu.asu.classsearch.input.get_Input;
import edu.asu.classsearch.pages.ClassSearchResults_Validator;
import edu.asu.classsearch.pages.ClassSearch_AdvancedSearch;
import edu.asu.classsearch.pages.ClassSearch_Filters;
import edu.asu.classsearch.pages.classearch_HomePage_Methods;
import edu.asu.classsearch.pages.classearch_commons;

public class ClassSearch_Filters_Automation {
	
	private ClassSearchResults_Validator val;
	private WebDriver driver;
	private classearch_HomePage_Methods home;
	private classearch_HomePage_Methods prodHome;
	private ClassSearch_Filters filters; 
	private ClassSearch_Filters prodFilters;
	
	private WebDriver prodDriver;
	private ClassSearch_AdvancedSearch prodAdv;
	private ClassSearch_AdvancedSearch adv;
	
	private String testCase="";
	
	@Before
	public void before(Scenario scenario) {
	    String scenarioName=scenario.getName();
	    this.testCase=scenarioName.substring(0,scenarioName.indexOf(" "));
	}

	//creates a connection
	@Given("^The user is on Class Search page Filter Search$")
	public void getconnection(){
		driver=classearch_commons.getconn("https://webapp4-dev.asu.edu/elastic-catalog/");
		prodDriver=classearch_commons.getconn("https://webapp4-dev.asu.edu/catalog/");
		
		val=new ClassSearchResults_Validator(driver);
		home=new classearch_HomePage_Methods(driver);
		adv=new ClassSearch_AdvancedSearch(driver);
		filters=new ClassSearch_Filters(driver);
		prodFilters=new ClassSearch_Filters(prodDriver);
		
		prodAdv=new ClassSearch_AdvancedSearch(prodDriver);
		prodHome=new classearch_HomePage_Methods(prodDriver);
	}
	
	//TC_43
	@When("^User toggles the In-Person & iCourses/ASU Online Classes toggle to ASU Online Classes$")
	public void filters_ASUOnline(){
		String []values=get_Input.inputload(testCase).split(",");
		String searchterm=values[0];
		String number=values[1];
		home.subjectandnumber(searchterm,number);
		home.performsearch();
		filters.toggleASUOnline();
		
		prodHome.subjectandnumber(searchterm,number);
		prodHome.performsearch();
		prodFilters.toggleASUOnline();
		
	}
	@Then("^The Results should contain Only ASU Online Courses$")
	public void verify_ASUOnline(){
		//String results=subject_number();
		val.verifyResultWithProd(prodDriver);
	}
	
	
	@And("^User toggles back In-Person & iCourses$")
	public void filters_InPerson(){
		filters.toggleInPerson();
		prodFilters.toggleInPerson();
		
	}
	@And("^In-Person and iCourses return again$")
	public void verify_InPerson(){
		//String results=subject_number();
		val.verifyResultWithProd(prodDriver);
		
		driver.quit();
		prodDriver.quit();
	}
	
	
	//TC_44
	@When("^User performs a search with default filters\\(Open Classes\\)$")
	public void filters_OpenClasses(){
		String []values=get_Input.inputload(testCase).split(",");
		String searchterm=values[0];
		String number=values[1];
		home.subjectandnumber(searchterm,number);
		home.performsearch();
		
		prodHome.subjectandnumber(searchterm,number);
		prodHome.performsearch();
		
	}
	@Then("^The Results should contain only classes with seats available$")
	public void verify_OpenClasses(){
		//String results=subject_number();
		val.verifyResultWithProd(prodDriver);
	}
	
	
	@And("^User clicks All Classes toggle$")
	public void filters_AllClasses(){
		filters.toggleAllClasses();
		prodFilters.toggleAllClasses();
	}
	
	@And("^All classes full and open should display$")
	public void verify_AllClasses(){
		//String results=subject_number();
		val.verifyResultWithProd(prodDriver);
		
		driver.quit();
		prodDriver.quit();
	}
	
	
	//TC_45
	@When("^User performs a search with different combination of session filters$")
	public void filters_Session(){
		String []values=get_Input.inputload(testCase).split(",");
		String searchterm=values[0];
		home.subject(searchterm);
		home.performsearch();
		
		prodHome.subject(searchterm);
		prodHome.performsearch();
		
	}
	@Then("^The Results should contain only the classes of the session type\\(s\\) in the filter$")
	public void verify_Session(){
		//String results=subject_number();
		
		String []sessions={"A","B","C","DYN"};
		List<String> sessionSubset=new ArrayList<String>();
		int n=sessions.length;
		for(int i=0;i<(1<<n);i++){
			sessionSubset.clear();
			for(int j=0;j<n;j++){
				if((i & (1<<j))>0){
					sessionSubset.add(sessions[j]);
				}
			}
			
			System.out.println("Verifying with sessions ");
			for(String s:sessionSubset){
				System.out.print(s+" ");
			}
			
			filters.filterBySession(sessionSubset);
			prodFilters.filterBySession(sessionSubset);
			val.verifyResultWithProd(prodDriver);
		}
		driver.quit();
		prodDriver.quit();
		
	}
	
	//TC_46
	@When("^User performs a search with School and Level and applies Filters$")
	public void filters_School_Level_Location(){
		String []values=get_Input.inputload(testCase).split(",");
		String school=values[0];
		String level=values[1];
		adv.clickAdvancedSearch();
		adv.selectCollegeSchool(school);
		adv.selectLevel(level);
		home.performsearch();
		
		prodAdv.clickAdvancedSearch();
		prodAdv.selectCollegeSchool(school);
		prodAdv.selectLevel(level);
		prodHome.performsearch();
		
	}
	@Then("^The Results should return for filters Polytechnic, Tempe, West, iCourse and Off-Campus and combinations matching filters, other locations do not return results$")
	public void verify_School_Level_Location(){
		//String results=subject_number();
		String []values=get_Input.inputload(testCase).split(",");
		String []locations=Arrays.copyOfRange(values, 2, values.length);
		List<String> locationSubset=new ArrayList<String>();
		int n=locations.length;
		for(int i=0;i<(1<<n);i++){
			locationSubset.clear();
			for(int j=0;j<n;j++){
				if((i & (1<<j))>0){
					locationSubset.add(locations[j]);
				}
			}
			
			System.out.println("Verifying with sessions ");
			for(String s:locationSubset){
				System.out.print(s+" ");
			}
			
			filters.filterByLocation(locationSubset);
			prodFilters.filterByLocation(locationSubset);
			val.verifyResultWithProd(prodDriver);
		}
		
		driver.quit();
		prodDriver.quit();
	}
	
	//TC_47
	@When("^User performs a search with subject and filter by Thunderbird$")
	public void filters_Location_TBD(){
		String []values=get_Input.inputload(testCase).split(",");
		String subject=values[0];
		home.subject(subject);
		home.performsearch();
		
		prodHome.subject(subject);
		prodHome.performsearch();
		
	}
	@Then("^Results should return for Thunderbird matching filter other locations do not return results$")
	public void verify_Location_TBD(){
		//String results=subject_number();
		
		String []locations={"Thunderbird"};
		List<String> locationSubset=new ArrayList<String>();
		int n=locations.length;
		for(int i=0;i<(1<<n);i++){
			locationSubset.clear();
			for(int j=0;j<n;j++){
				if((i & (1<<j))>0){
					locationSubset.add(locations[j]);
				}
			}
			
			System.out.print("\nVerifying with sessions ");
			for(String s:locationSubset){
				System.out.print(s+" ");
			}
			
			filters.filterByLocation(locationSubset);
			prodFilters.filterByLocation(locationSubset);
			val.verifyResultWithProd(prodDriver);
		}
		
		driver.quit();
		prodDriver.quit();
	}
	
	//TC_48
	@When("^User performs a search with subject and applies Location filter$")
	public void filters_subject_Location(){
		String []values=get_Input.inputload(testCase).split(",");
		String subject=values[0];
		home.subject(subject);
		home.performsearch();
		
		prodHome.subject(subject);
		prodHome.performsearch();
		
	}
	@Then("^Results should return for locations matching the filter other locations do not return results$")
	public void verify_subject_Location(){
		//String results=subject_number();
		String []values=get_Input.inputload(testCase).split(",");
		String []locations=Arrays.copyOfRange(values, 1, values.length);
		List<String> locationSubset=new ArrayList<String>();
		int n=locations.length;
		for(int i=0;i<(1<<n);i++){
			locationSubset.clear();
			for(int j=0;j<n;j++){
				if((i & (1<<j))>0){
					locationSubset.add(locations[j]);
				}
			}
			
			System.out.print("\nVerifying with sessions ");
			for(String s:locationSubset){
				System.out.print(s+" ");
			}
			System.out.println();
			filters.filterByLocation(locationSubset);
			prodFilters.filterByLocation(locationSubset);
			val.verifyResultWithProd(prodDriver);
		}
		
		driver.quit();
		prodDriver.quit();
	}
	
	//TC_49
	@When("^User performs a search with college/school and applies Location filter$")
	public void filters_College_Location(){
		String []values=get_Input.inputload(testCase).split(",");
		String school=values[0];
		adv.clickAdvancedSearch();
		adv.selectCollegeSchool(school);
		home.performsearch();
		
		prodAdv.clickAdvancedSearch();
		prodAdv.selectCollegeSchool(school);
		prodHome.performsearch();
		
	}
	
	//TC_48
	@When("^User performs a search with School and applies Days filter$")
	public void filters_School_Days(){
		String []values=get_Input.inputload(testCase).split(",");
		String college=values[0];
		adv.clickAdvancedSearch();
		adv.selectCollegeSchool(college);
		home.performsearch();
		
		prodAdv.clickAdvancedSearch();
		prodAdv.selectCollegeSchool(college);
		prodHome.performsearch();
		
	}
	@Then("^Results should return any class with any day in the filter set$")
	public void verify_School_Days(){
		//String results=subject_number();
		String []values=get_Input.inputload(testCase).split(",");
		String []days=Arrays.copyOfRange(values, 1, values.length);
		List<String> daySubset=new ArrayList<String>();
		filters.expandDaysFilter();
		prodFilters.expandDaysFilter();

		int n=days.length;
		for(int i=0;i<(1<<n);i++){
			daySubset.clear();
			for(int j=0;j<n;j++){
				if((i & (1<<j))>0){
					daySubset.add(days[j]);
				}
			}
			
			System.out.print("\nVerifying with Days ");
			for(String s:daySubset){
				System.out.print(s+" ");
			}
			System.out.println();
			
			filters.filterByDaysOfWeek(daySubset);
			prodFilters.filterByDaysOfWeek(daySubset);
			val.verifyResultWithProd(prodDriver);
		}
		
		driver.quit();
		prodDriver.quit();
	}

}