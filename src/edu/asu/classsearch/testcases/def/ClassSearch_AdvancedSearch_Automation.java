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
	public void positive_Subject_Instructor(){

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
	public void validate_Subject_Instructor(){
		//Validate Subject Details and Instructor Details
		val.validateSubjectName(validateString[0]);
		val.validateInstructorName(validateString[1]);
		MatcherAssert.assertThat(results,CoreMatchers.containsString("Showing"));
		driver.quit();
		
	}
	
	@When("^User performs a search using a college/school$")
	public void positive_CollegeSchool(){
		String values[]=get_Input.inputload("TC_23").split(",");
		String college=values[0];
		validateString=new String[1];
		validateString[0]=college;
		adv.clickAdvancedSearch();
		adv.selectCollegeSchool(college);
		home.performsearch();
		this.results=home.assertresults();
		
	}
	
	@Then("^The results should contain records with the selected college/school$")
	public void validate_CollegeSchool(){
		//TODO: See if there is a way to validate collegeSchool
		MatcherAssert.assertThat(results,CoreMatchers.containsString("Showing"));
		driver.quit();
	}

	@When("^User selects # of Units and subject and performs search$")
	public void positive_NumofUnits(){
		String values[]=get_Input.inputload("TC_24").split(",");
		String subject=values[0];
		String numUnits=values[1];
		validateString=new String[2];
		validateString[0]=subject;
		validateString[1]=numUnits;
		home.subject(subject);
		adv.clickAdvancedSearch();
		adv.selectNumberofUnits(numUnits);
		home.performsearch();
		this.results=home.assertresults();
		
	}
	
	@Then("^The results should contain only classes with the given number of units$")
	public void validate_NumofUnits(){
		//TODO: See if there is a way to validate collegeSchool
		val.validateSubjectName(validateString[0]);
		val.validateNumberOfUnits(validateString[1]);
		MatcherAssert.assertThat(results,CoreMatchers.containsString("Showing"));
		driver.quit();
	}
	
	@When("^User selects Class # and subject and performs search$")
	public void positive_ClassNumber(){
		String values[]=get_Input.inputload("TC_25").split(",");
		String subject=values[0];
		String classNum=values[1];
		validateString=new String[2];
		validateString[0]=subject;
		validateString[1]=classNum;
		home.subject(subject);
		adv.clickAdvancedSearch();
		adv.enterClassNumber(classNum);
		home.performsearch();
		this.results=home.assertresults();
		
	}
	
	@Then("^The results should contain only classes with that class number$")
	public void validate_ClassNumber(){
		//TODO: See if there is a way to validate collegeSchool
		val.validateSubjectName(validateString[0]);
		val.validateClassNumber(validateString[1]);
		MatcherAssert.assertThat(results,CoreMatchers.containsString("Showing"));
		driver.quit();
	}
	
	@When("^User enters Start Date and subject and performs search$")
	public void positive_StartDate(){
		String values[]=get_Input.inputload("TC_26").split(",");
		String subject=values[0];
		String startDate=values[1];
		validateString=new String[2];
		validateString[0]=subject;
		validateString[1]=startDate;
		home.subject(subject);
		adv.clickAdvancedSearch();
		adv.enterStartDate(startDate);
		home.performsearch();
		this.results=home.assertresults();
		
	}
	
	@Then("^The results should contain only classes only classes starting on or after the date should return$")
	public void validate_StartDate(){
		//TODO: See if there is a way to validate collegeSchool
		val.validateSubjectName(validateString[0]);
		val.validateStartDate(validateString[1]);
		MatcherAssert.assertThat(results,CoreMatchers.containsString("Showing"));
		driver.quit();
	}
	
	//27: User Enters correct subject and End Date 
		@When("^User performs a search using the correct Subject and End Date$")
		public void Postive_EndDate(){
			String []values=get_Input.inputload("TC_27").split(",");
			String subject=values[0];
			String endDate=values[1];
			validateString=new String[2];
			validateString[0]=subject;
			validateString[1]=endDate;
			home.subject(subject);
			adv.clickAdvancedSearch();
			adv.enterEndDate(endDate);
			home.performsearch();
		  this.results=home.assertresults();

		}
		@Then("^The Results must display only classes ending on or after the date$")
		public void validate_EndDate(){
			//Validate Subject Details and Instructor Details
			val.validateSubjectName(validateString[0]);
			val.validateEndDate(validateString[1]);
			MatcherAssert.assertThat(results,CoreMatchers.containsString("Showing"));
			driver.quit();
			
		}

		//28: User Enters correct subject and checks Honors 
		@When("^User performs a search using the correct Subject and checks Honors check box$")
		public void positive_Honors(){
			String []values=get_Input.inputload("TC_28").split(",");
			String subject=values[0];
			validateString=new String[1];
			validateString[0]=subject;
			home.subject(subject);
			adv.clickAdvancedSearch();
			adv.clickHonors();
			home.performsearch();
		  this.results=home.assertresults();

		}
		@Then("^The Results must display only honors classes or classes that offer honors enrichment contracts$")
		public void validate_Honors(){
			//Validate Subject Details and Instructor Details
			val.validateSubjectName(validateString[0]);
			val.validateHonorsTitle();
			MatcherAssert.assertThat(results,CoreMatchers.containsString("Showing"));
			driver.quit();
			
		}
		
		//29: User Enters correct subject and checks Promod 
		@When("^User performs a search using the correct Subject and checks Project-based check box$")
		public void positive_Promod(){
			String []values=get_Input.inputload("TC_29").split(",");
			String subject=values[0];
			validateString=new String[1];
			validateString[0]=subject;
			home.subject(subject);
			adv.clickAdvancedSearch();
			adv.clickPromod();
			home.performsearch();
		  this.results=home.assertresults();

		}
		@Then("^The Results must display only Promod block classes or individual classes designated as project based with a special note 0018$")
		public void validate_promod(){
			//Validate Subject Details and Instructor Details
			val.validateSubjectName(validateString[0]);
			val.validatePromod();
			MatcherAssert.assertThat(results,CoreMatchers.containsString("Showing"));
			driver.quit();
			
		}
		
		//30: User Searches using General studies 
		@When("^User performs a search using General Studies option$")
		public void positive_GeneralStudies(){
			String []values=get_Input.inputload("TC_30").split("&");
			String gs=values[0];
			validateString=values;
			adv.clickAdvancedSearch();
			adv.selectGeneralStudies(gs);
			//If GS option 1 is provided
			if(values.length>1){
				validateString[1]=values[1];
				adv.selectGeneralStudiesOption1(values[1]);
				//If GS option 1 is provided
				if(values.length>2){
					validateString[2]=values[2];
					adv.selectGeneralStudiesOption2(values[2]);
				}
			}
			
			home.performsearch();
		  this.results=home.assertresults();

		}
		
		@Then("^The Results must display only classes with the chosen GS category$")
		public void validate_GeneralStudies(){
			//Validate Subject Details and Instructor Details
			val.validateGeneralStudies(validateString);
			MatcherAssert.assertThat(results,CoreMatchers.containsString("Showing"));
			driver.quit();
			
		}


}
