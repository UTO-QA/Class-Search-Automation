package edu.asu.classsearch.pages;

import java.util.List;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ClassSearchResults_Validator {
	private WebDriver driver;
	public ClassSearchResults_Validator(WebDriver driver){
		this.driver=driver;
	}
	
	//Validates the subject name and Number(Optional) in the search results.
	public void validateSubjectName(String subjectNumber){
		try{
			List<WebElement> subjectList=driver.findElements(By.className("subjectNumberColumnValue"));
			for(WebElement w:subjectList){
				MatcherAssert.assertThat(w.getText(), CoreMatchers.containsString(subjectNumber));
				//System.out.println(w.getText());
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		System.out.println("Validated Against "+subjectNumber);
	}
	
	public void validateInstructorName(String instructor){
		try{
			List<WebElement> instructorList=driver.findElements(By.className("instructorListColumnValue"));
			for(WebElement w:instructorList){
				MatcherAssert.assertThat(w.getText(), CoreMatchers.containsString(instructor));
				System.out.println("Validated Against "+w.getText());
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	public void validateClassNumber(String classNumber){
		try{
			List<WebElement> classNumberList=driver.findElements(By.className("classNbrColumnValue"));
			for(WebElement w:classNumberList){
				MatcherAssert.assertThat(w.getText(), CoreMatchers.containsString(classNumber));
				System.out.println("Validated Against "+w.getText());
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	public void validateStartDate(String startDate){
		try{
			List<WebElement> classNumberList=driver.findElements(By.className("startDateColumnValue"));
			for(WebElement w:classNumberList){
				MatcherAssert.assertThat(w.getText(), CoreMatchers.startsWith(startDate));
				System.out.println("Validated Against "+w.getText());
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	public void validateEndDate(String endDate){
		try{
			List<WebElement> classNumberList=driver.findElements(By.className("startDateColumnValue"));
			for(WebElement w:classNumberList){
				MatcherAssert.assertThat(w.getText(), CoreMatchers.containsString(endDate));
				System.out.println("Validated Against "+w.getText());
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
}
