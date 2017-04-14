package edu.asu.classsearch.testcases.def;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import edu.asu.classearch.driver.ClassSearch_Driver;
import edu.asu.classsearch.input.get_Input;
import edu.asu.classsearch.pages.ClassSearchResults_Validator;
import edu.asu.classsearch.pages.classearch_HomePage_Methods;
import edu.asu.classsearch.pages.classearch_commons;
import junit.framework.Assert;

public class classsearch_Homepage_Automation {
	
	private classearch_HomePage_Methods classearch_HomePage_Methods;
	private WebDriver driver;
	private String results;
	private String results_1;
	
	//New Class to Validate Search Results
	private ClassSearchResults_Validator val;
	private String validateString="";
	//creates a connection
	@Given("^The user is on Class Search page$")
	public void getconnection(){
		driver=ClassSearch_Driver.getInstance();
		classearch_HomePage_Methods=new classearch_HomePage_Methods(driver);
		val=new ClassSearchResults_Validator(driver);
	}
	//delete a connection
	public void closeconnection(){
		classearch_commons.closeconn();
	}
	//TEST1: CHECK if course accepts Positive Subject 
	@When("^User enters Correct Subject$")
	public void Postive1_subject(){
		String []values=get_Input.inputload("TC_1").split(",");
		String searchterm=values[0];
		validateString=searchterm;
		classearch_HomePage_Methods.subject(searchterm);
		classearch_HomePage_Methods.performsearch();
	  this.results=classearch_HomePage_Methods.assertresults();

	}
	@Then("^The Results with correct subject info should be Displayed$")
	public void test_Positive1_subject(){
		//String results=Postive1_subject();
		val.validateSubjectName(validateString);
		MatcherAssert.assertThat(results,CoreMatchers.containsString("Showing"));
		closeconnection();
		
	}
	//TEST2: CHECK if course rejects Negative Subject
	@When("^User enters Incorrect Subject$")
	public void incorrect_subject1(){
		String []values=get_Input.inputload("TC_2").split(",");
		String searchterm=values[0];
		classearch_HomePage_Methods.subject(searchterm);
		classearch_HomePage_Methods.performsearch();
		this.results=classearch_HomePage_Methods.assertresults();
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
			String []values=get_Input.inputload("TC_3").split(",");
			String searchterm=values[0];
			String number=values[1];
			validateString=searchterm+" "+number;
			classearch_HomePage_Methods.subjectandnumber(searchterm,number);
			classearch_HomePage_Methods.performsearch();
		    results=classearch_HomePage_Methods.assertresults();
			//closeconnection();
			
		}
		@Then("^The Results should be Displayed for Correct Subject and Number scenario$")
		public void test_subject_number(){
			//String results=subject_number();
			val.validateSubjectName(validateString);
			closeconnection();
			MatcherAssert.assertThat(results,CoreMatchers.containsString("Showing"));
		}
   //TEST4: CHECK if course rejects Incorrect Subject  and Incorrect Number
		@When("^User enters incorrect Subject and incorrect Number$")
		public void subject1_number(){
			String []values=get_Input.inputload("TC_4").split(",");
			String searchterm=values[0];
			String number=values[1];
			classearch_HomePage_Methods.subjectandnumber(searchterm,number);
			classearch_HomePage_Methods.performsearch();
			this.results=classearch_HomePage_Methods.assertresults();
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
			String []values=get_Input.inputload("TC_5").split(",");
			String searchterm=values[0];
			String number=values[1];
					classearch_HomePage_Methods.subjectandnumber(searchterm,number);
					classearch_HomePage_Methods.performsearch();
					this.results=classearch_HomePage_Methods.assertresults();
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
					String []values=get_Input.inputload("TC_6").split(",");
					String number=values[0];
					
					classearch_HomePage_Methods.Number(number);
					classearch_HomePage_Methods.performsearch();
					this.results=classearch_HomePage_Methods.assertresults();
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
					String []values=get_Input.inputload("TC_7").split(",");
					String number=values[0];
							classearch_HomePage_Methods.Number(number);
							classearch_HomePage_Methods.performsearch();
							this.results=classearch_HomePage_Methods.assertresults();
							
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
					String []values=get_Input.inputload("TC_8").split(",");
					String keyword=values[0];
					classearch_HomePage_Methods.keyword(keyword);
					classearch_HomePage_Methods.performsearch();
					this.results=classearch_HomePage_Methods.assertresults();
					//closeconnection();
					
			}
		@Then("^The search results page is displayed for correct keyword scenario$")
		public void test_keyword(){
			//String results=keyword();
			MatcherAssert.assertThat(results,CoreMatchers.containsString("Showing"));
			closeconnection();
	}
	//TEST9: Verify that search with only incorrect keyword produces proper warning message
				@When("^User performs a search using only the incorrect keyword or keyword with less than 3 letters$")
				public void incorrect_keyword(){
					String []values=get_Input.inputload("TC_9").split(",");
					String keyword=values[0];
					String keyword_lim=values[1];
							classearch_HomePage_Methods.keyword(keyword);
							classearch_HomePage_Methods.performsearch();
							this.results=classearch_HomePage_Methods.assertresults();
							classearch_HomePage_Methods.keyword(keyword_lim);
							classearch_HomePage_Methods.performsearch();
							this.results_1=classearch_HomePage_Methods.assertresults();
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
					String []values=get_Input.inputload("TC_10").split(",");
					String Subject=values[0];
					String keyword=values[1];
					validateString=Subject;
					classearch_HomePage_Methods.keywordanddsubject(Subject, keyword);
					classearch_HomePage_Methods.performsearch();
					this.results=classearch_HomePage_Methods.assertresults();
							
					}
				@Then("^The Search Results page is Displayed for correct keyword and subject scenario$")
				public void test_correct_keyword_Subject(){
					//String results=correct_keyword_Subject();
					val.validateSubjectName(validateString);
					closeconnection();
					MatcherAssert.assertThat(results,CoreMatchers.containsString("Showing"));
			}
				
	//TEST 11: Verify that search with Correct Subject and  keyword produces Search results
				@When("^User performs a search using the incorrect keyword or Subject$")
				public void incorrect_keyword_Subject(){
					String []values=get_Input.inputload("TC_11").split(",");
					String Subject=values[0];
					String keyword=values[1];
							classearch_HomePage_Methods.keywordanddsubject(Subject, keyword);
							classearch_HomePage_Methods.performsearch();
							this.results=classearch_HomePage_Methods.assertresults();
							
					}
				@Then("^The Warning is Displayed for incorrect keyword or subject scenario$")
				public void test_incorrect_keyword_Subject(){
					//String results=incorrect_keyword_Subject();
					closeconnection();
					Assert.assertEquals(results, "Please update your search criteria and try again.");
			}	
				
	//TEST 12: Verify that toggle the radio button changes the results
				@When("^User selects for open classes and performs a search$")
				public void toggleradio_open(){
					String []values=get_Input.inputload("TC_12").split(",");
					String term=values[0];
					String subject=values[1];
					String open=values[2];
					classearch_HomePage_Methods.selectaterm(term);
					classearch_HomePage_Methods.check_ifopenorall(open);
					classearch_HomePage_Methods.subject(subject);
					classearch_HomePage_Methods.performsearch();
					
					
				}
				@Then("^The Results should only contain open values$")
				public void verifytoggleradio_open(){
					String value=classearch_HomePage_Methods.verify_results("checkopenorall");
					Assert.assertEquals("true",value);
					closeconnection();
				}
	//TEST 13: Verify that toggle the radio button changes the results
				@When("^User selects for all classes and performs a search$")
				public void toggleradio_all(){
					String []values=get_Input.inputload("TC_13").split(",");
					String term=values[0];
					String subject=values[1];
					String all=values[2];
					classearch_HomePage_Methods.check_ifopenorall(all);
					classearch_HomePage_Methods.selectaterm(term);
					classearch_HomePage_Methods.subject(subject);
					classearch_HomePage_Methods.performsearch();
					
					
				}
				@Then("^The Results should contain open and closed values$")
				public void verifytoggleradio_all(){
					String value=classearch_HomePage_Methods.verify_results("checkopenorall");
					Assert.assertEquals("false",value);
					closeconnection();
				}
	//TEST 14: Verify that the results displayed contain only campus classes when in-Person is selected
				@When("^User selects for in-person and performs a search$")
				public void toggleradio_campus(){
					String []values=get_Input.inputload("TC_14").split(",");
					String campus=values[0];
					String sem=values[1];
					String subject=values[2];
					classearch_HomePage_Methods.check_campusoronline(campus);
					classearch_HomePage_Methods.selectaterm(sem);
					classearch_HomePage_Methods.subject(subject);
					classearch_HomePage_Methods.performsearch();
					
					
				}
				@Then("^The Results should contain only On-Campus Classes$")
				public void verifytoggleradio_campus(){
					String value=classearch_HomePage_Methods.verify_results("location");
					Assert.assertEquals("true",value);
					closeconnection();
				}
	//TEST 15: Verify that the results displayed contain only ASUONLINE classes when online is selected
				@When("^User selects for online and performs a search$")
				public void toggleradio_online(){
					String []values=get_Input.inputload("TC_15").split(",");
					String campus=values[0];
					String sem=values[1];
					String subject=values[2];
					classearch_HomePage_Methods.check_campusoronline(campus);
					classearch_HomePage_Methods.selectaterm(sem);
					classearch_HomePage_Methods.subject(subject);
					classearch_HomePage_Methods.performsearch();
					
					
				}
				@Then("^The Results should contain only online Classes$")
				public void verifytoggleradio_online(){
					String value=classearch_HomePage_Methods.verify_results("location");
					Assert.assertEquals("false",value);
					closeconnection();
				}
				
//TEST 16:
				@When("^User selects Session A and performs a search$")
				public void Session_A(){
					String []values=get_Input.inputload("TC_16").split(",");
					String campus=values[0];
					String sem=values[1];
					String subject=values[2];
					String session=values[3];
					String openorall=values[4];
					classearch_HomePage_Methods.check_campusoronline(campus);
					classearch_HomePage_Methods.selectaterm(sem);
					classearch_HomePage_Methods.subject(subject);
					classearch_HomePage_Methods.check_ifopenorall(openorall);
					classearch_HomePage_Methods.performsearch();
					classearch_HomePage_Methods.select_session(session);
					this.results=session;
				}
				@Then("^The Results should contain only Session A classes$")
				public void verifySession_A(){
					boolean session_verify=classearch_HomePage_Methods.verify_session(results);
					Assert.assertEquals(session_verify, true);
					closeconnection();
				}
				@When("^User selects Session B and performs a search$")
				public void Session_B(){
					String []values=get_Input.inputload("TC_16").split(",");
					String campus=values[0];
					String sem=values[1];
					String subject=values[2];
					String session=values[3];
					String openorall=values[4];
					classearch_HomePage_Methods.check_campusoronline(campus);
					classearch_HomePage_Methods.selectaterm(sem);
					classearch_HomePage_Methods.subject(subject);
					classearch_HomePage_Methods.check_ifopenorall(openorall);
					classearch_HomePage_Methods.performsearch();
					classearch_HomePage_Methods.select_session(session);
					this.results=session;
					
				}
				@Then("^The Results should contain only Session B classes$")
				public void verifySession_B(){
					boolean session_verify=classearch_HomePage_Methods.verify_session(results);
					Assert.assertEquals(session_verify, true);
					closeconnection();
				}
				@When("^User selects Session C and performs a search$")
				public void Session_C(){
					String []values=get_Input.inputload("TC_16").split(",");
					String campus=values[0];
					String sem=values[1];
					String subject=values[2];
					String session=values[3];
					String openorall=values[4];
					classearch_HomePage_Methods.check_campusoronline(campus);
					classearch_HomePage_Methods.selectaterm(sem);
					classearch_HomePage_Methods.subject(subject);
					classearch_HomePage_Methods.check_ifopenorall(openorall);
					classearch_HomePage_Methods.performsearch();
					classearch_HomePage_Methods.select_session(session);
					this.results=session;
					
				}
				@Then("^The Results should contain only Session C classes$")
				public void verifySession_C(){
					boolean session_verify=classearch_HomePage_Methods.verify_session(results);
					Assert.assertEquals(session_verify, true);
					closeconnection();
				}


}
