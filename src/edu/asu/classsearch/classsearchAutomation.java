package edu.asu.classsearch;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.Then;

public class classsearchAutomation {

	private WebDriver driver;
	classearchmap map=new classearchmap();
	//creates a connection
	public void getconnection(){
		map.getconn();
	}
	//delete a connection
	public void closeconnection(){
		map.closeconn();
	}
	//TEST1: CHECK if course accepts Positive Keyword
	@Then("The Results should be Displayed")
	public String test_subject(){
		String searchterm="CSE";
		map.subject(searchterm);
		map.performsearch();
		String results=map.assertresults();
		return results;
	}
	//TEST2: CHECK if course rejects Negative Keyword
	public String test_subject1(){
		String searchterm="AAA";
		map.subject(searchterm);
		map.performsearch();
		String results=map.assertresults();
		return results;
	}
	//TEST3: CHECK if course accepts Positive Keyword and Number
		public String test_subject_number(){
			String searchterm="CSE";
			String number="120";
			map.subjectandnumber(searchterm,number);
			map.performsearch();
			String results=map.assertresults();
			return results;
		}
   //TEST4: CHECK if course rejects Positive keyword and Number
		public String test_subject1_number(){
			String searchterm="CSE";
			String number="101";
			map.subjectandnumber(searchterm,number);
			map.performsearch();
			String results=map.assertresults();
			return results;
		}
	//TEST5: CHECK if course rejects Negative keyword and Number
		public String test_subject_2_number(){
					String searchterm="120";
					String number="CSE";
					map.subjectandnumber(searchterm,number);
					map.performsearch();
					String results=map.assertresults();
					return results;
			}
}
