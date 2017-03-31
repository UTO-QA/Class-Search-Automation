package edu.asu.classsearch.pages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import static org.hamcrest.Matchers.*;
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
			
			String startDateSplit[]=startDate.split("/");
			Integer month=Integer.parseInt(startDateSplit[0]);
			Integer day=Integer.parseInt(startDateSplit[1]);
			List<WebElement> classNumberList=driver.findElements(By.className("startDateColumnValue"));
			for(WebElement w:classNumberList){
				
				String columnValue=w.getText();
				String listStartDate[]=columnValue.split("-")[0].trim().split("/");
				
				//Convert list date to month and day
				int listMonth=Integer.parseInt(listStartDate[0]);
				int listDay=Integer.parseInt(listStartDate[1]);
				MatcherAssert.assertThat(startDate+" must fall on or after "+columnValue, listMonth>month || (month==listMonth && listDay>=day));
				System.out.println("Validated Against "+w.getText());
				
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}

	
	public void validateNumberOfUnits(String units){
		try{
			
			//Case when units does not contain or more
			
			if(units.contains("or more")){
				//Get the number displayed
				units=units.substring(0, 1);
			}
			
			Integer unitsinInt=Integer.parseInt(units);
			
			List<WebElement> hoursList=driver.findElements(By.className("hoursColumnValue"));
			for(WebElement w:hoursList){
				String columnValue=w.getText();
				if(columnValue.contains("-")){
					String unitRange[]=columnValue.split("-");
					MatcherAssert.assertThat(columnValue+" Range must contain the selected units: "+units,(unitsinInt>=Integer.parseInt(unitRange[0])) && unitsinInt<=Integer.parseInt(unitRange[1]));
				}
				else {
					MatcherAssert.assertThat(w.getText(), CoreMatchers.containsString(units));
				}
				
				System.out.println("Validated Against "+w.getText());
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	//Goes Into the validator class
		public void validateEndDate(String endDate){
			try{
				String endDateSplit[]=endDate.split("/");
				int month=Integer.parseInt(endDateSplit[0]);
				int day=Integer.parseInt(endDateSplit[1]);
				
				List<WebElement> classNumberList=driver.findElements(By.className("startDateColumnValue"));
				for(WebElement w:classNumberList){
					String columnValue=w.getText();
					String columnEndDate[]=columnValue.split("-")[1].trim().split("/");
					int listMonth=Integer.parseInt(columnEndDate[0]);
					int listDay=Integer.parseInt(columnEndDate[1].substring(0, 2));
					MatcherAssert.assertThat(endDate+" must fall in the date range "+ columnValue, listMonth<month || (listMonth==month && listDay<day) );
					System.out.println("Validated Against "+w.getText());
				}
			}
			catch(Exception e){
				e.printStackTrace();
			}
			
		}

		public void validateHonorsTitle(){
			try{
				List<WebElement> honorsList=driver.findElements(By.className("honorshead"));
				List<String> honorTextList=new ArrayList<String>();
				for(WebElement w: honorsList){
					honorTextList.add(w.getText());
				}
				
				MatcherAssert.assertThat(honorTextList, contains("Honors-only Class Sections"));
				//"The classes listed below offer Honors Enrichment Contracts; to inquire about contracts for classes not identified below, please contact the instructor."));			
				System.out.println("Validated against Honors");
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
		public void validatePromod(){
			try{
				List<WebElement> promodImgList=driver.findElements(By.className("classNbrColumnValue"));
				for(WebElement w:promodImgList){
					//Check if the promod icon is displayed
					MatcherAssert.assertThat(w.findElement(By.xpath("//span[@class='icontip']/img[@alt='Project-based course']")).getAttribute("src"),CoreMatchers.containsString("icon_pb.png"));
				}
				
				
			}
			catch(Exception e){
				e.printStackTrace();
			}			
		}
		
		public void validateGeneralStudies(String[] values){
			List<WebElement> gsColumnList=driver.findElements(By.className("tooltipRqDesDescrColumnValue"));
			
			//Set value[0];
			values[0]=values[0].split(":")[0];
			for(WebElement w:gsColumnList){
				String []gsColumnSplit=w.getText().split("&");
				
				//Trim the values to remove the trailing space
				for(int i=0;i<gsColumnSplit.length;i++){
					gsColumnSplit[i]=gsColumnSplit[i].trim();
				}
								
				if(gsColumnSplit[0].contains(values[0])) gsColumnSplit[0]=values[0];
				MatcherAssert.assertThat(Arrays.asList(gsColumnSplit), hasItems(values));	

				System.out.println("Validated against "+ w.getText());	
			}
			
			
		}

	
}
