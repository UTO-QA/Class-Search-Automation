package edu.asu.classsearch;

import static org.hamcrest.MatcherAssert.assertThat;
import org.hamcrest.CoreMatchers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class classsearch_Homepage_Automation {

	private WebDriver driver;
	private String results;
	private String results_1;
	classearch_HomePage_Methods map=new classearch_HomePage_Methods();
	//creates a connection
	@Given("^The user is on Class Search page$")
	public void getconnection(){
		map.getconn();
	}
	//delete a connection
	public void closeconnection(){
		map.closeconn();
	}
	//TEST1: CHECK if course accepts Positive Subject 
	@When("^User enters Correct Subject$")
	public void Postive1_subject(){
		String searchterm="CSE";
		map.subject(searchterm);
		map.performsearch();
	  this.results=map.assertresults();

	}
	@Then("^The Results with correct subject info should be Displayed$")
	public void test_Positive1_subject(){
		//String results=Postive1_subject();
		closeconnection();
		assertThat(results,CoreMatchers.containsString("Showing"));
		
	}
	//TEST2: CHECK if course rejects Negative Subject
	@When("^User enters Incorrect Subject$")
	public void incorrect_subject1(){
		String searchterm="AAA";
		map.subject(searchterm);
		map.performsearch();
		this.results=map.assertresults();
		//
	}
	@Then("^A Warning should be Displayed for incorrect subject$")
	public void test_subject_incorrect(){
		//String results=incorrect_subject1();
		closeconnection();
		Assert.assertEquals(results,"Please update your search criteria and try again.");
	}

	//TEST3: CHECK if course accepts Positive Subject  and Number
		@When("^User enters correct Subject and Number$")
		public void subject_number(){
			String searchterm="CSE";
			String number="120";
			map.subjectandnumber(searchterm,number);
			map.performsearch();
		    results=map.assertresults();
			//closeconnection();
			
		}
		@Then("^The Results should be Displayed for Correct Subject and Number scenario$")
		public void test_subject_number(){
			//String results=subject_number();
			closeconnection();
			assertThat(results,CoreMatchers.containsString("Showing"));
		}
   //TEST4: CHECK if course rejects Incorrect Subject  and Incorrect Number
		@When("^User enters incorrect Subject and incorrect Number$")
		public void subject1_number(){
			String searchterm="CSE";
			String number="101";
			map.subjectandnumber(searchterm,number);
			map.performsearch();
			this.results=map.assertresults();
			//closeconnection();
			
		}
		@Then("^A Warning should be Displayed for incorrect subject and number scenario$")
		public void test_subject1_number(){
			//String results=subject1_number();
			closeconnection();
			Assert.assertEquals(results,"Please update your search criteria and try again.");
		}
	//TEST5: CHECK if course rejects Negative Subjectand Number
		
		@When("^User enters swapped values for Subject and Number$")
		public void subject_2_number(){
					String searchterm="120";
					String number="CSE";
					map.subjectandnumber(searchterm,number);
					map.performsearch();
					this.results=map.assertresults();
					//closeconnection();
					
			}
		@Then("^A Warning should be Displayed for swapped scenario$")
		public void test_subject_2_number(){
			//String results=subject_2_number();
			closeconnection();
			Assert.assertEquals(results, "Please update your search criteria and try again.");
	}
		//TEST 6:CHECK if search by only Number works
				@When("^User enters correct Number$")
				public void test_number(){
					String number="120";
					map.Number(number);
					map.performsearch();
					this.results=map.assertresults();
					//loseconnection();
			}
				@Then("^A Warning should be Displayed for correct Number Scenario$")
				public void validation_number(){
					//String results=test_number();
					closeconnection();
					Assert.assertEquals(results, "Please narrow your search by entering a subject, general studies or college.");
			}
		
	//TEST7: CHECK if search by incorrect number displays a warning message
				@When("^User enters incorrect Number$")	
		public void check_incorrect_number(){
							String number="1201.1";
							map.Number(number);
							map.performsearch();
							this.results=map.assertresults();
							
					}
		@Then("^A Warning should be Displayed for incorrect number scenario$")
		public void validation_incorrect_number(){
			//String results=test_number();
			closeconnection();
			Assert.assertEquals(results, "Please narrow your search by entering a subject, general studies or college.");
	}

	//TEST8: Verify that search with only keyword produces results
		@When("^User performs a search using only the correct keyword$")
		public void keyword(){
					String keyword="Data";
					map.keyword(keyword);
					map.performsearch();
					this.results=map.assertresults();
					//closeconnection();
					
			}
		@Then("^The search results page is displayed for correct keyword scenario$")
		public void test_keyword(){
			//String results=keyword();
			assertThat(results,CoreMatchers.containsString("Showing"));
			closeconnection();
	}
		//TEST9: Verify that search with only incorrect keyword produces proper warning message
				@When("^User performs a search using only the incorrect keyword or keyword with less than 3 letters$")
				public void incorrect_keyword(){
							String keyword="Hydra";
							String keyword_lim="Xu";
							map.keyword(keyword);
							map.performsearch();
							this.results=map.assertresults();
							map.keyword(keyword_lim);
							map.performsearch();
							this.results_1=map.assertresults();
							//closeconnection();
					}
				@Then("^An Appropriate warning message is displayed for incorrect keyword$")
				public void test_incorrect_keyword(){
					//String results=incorrect_keyword();
					closeconnection();
					Assert.assertEquals(results, "Please update your search criteria and try again.");
					Assert.assertEquals(results_1, "Keywords must be longer.");
					closeconnection();
			}	
		//TEST 10: Verify that search with Correct Subject and  keyword produces Search results
				@When("^User performs a search using the correct keyword and correct Subject$")
				public void correct_keyword_Subject(){
							String keyword="Data";
							String Subject="CSE";
							map.keywordanddsubject(Subject, keyword);
							map.performsearch();
							this.results=map.assertresults();
							
					}
				@Then("^The Search Results page is Displayed for correct keyword and subject scenario$")
				public void test_correct_keyword_Subject(){
					//String results=correct_keyword_Subject();
					closeconnection();
					assertThat(results,CoreMatchers.containsString("Showing"));
			}
				
		//TEST 11: Verify that search with Correct Subject and  keyword produces Search results
				@When("^User performs a search using the incorrect keyword or Subject$")
				public void incorrect_keyword_Subject(){
							String keyword="Anything";
							String Subject="CSE";
							map.keywordanddsubject(Subject, keyword);
							map.performsearch();
							this.results=map.assertresults();
							
					}
				@Then("^The Warning is Displayed for incorrect keyword or subject scenario$")
				public void test_incorrect_keyword_Subject(){
					//String results=incorrect_keyword_Subject();
					closeconnection();
					Assert.assertEquals(results, "Please update your search criteria and try again.");
			}	
				

}
