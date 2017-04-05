package edu.asu.classsearch.pages;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ClassSearch_Filters {
	
	WebDriver driver;

	//Location and corresponding xPaths
	static Map<String,String> locationxPath=new HashMap<String,String>()
	{{
		put("Downtown", 		 "//*[@id='DTPHX']");
		put("Polytechnic",		 "//*[@id='POLY']");
		put("Tempe",			 "//*[@id='TEMPE']");
		put("Thunderbird",		 "//*[@id='TBIRD']");
		put("West",				 "//*[@id='WEST']");
		put("AZ Western College","//*[@id='AWC']");
		put("Eastern AZ College","//*[@id='EAC']");
		put("Tucson",			 "//*[@id='TUCSON']");
		put("iCourse (online)",  "//*[@id='ICOURSE']");
		put("Off-campus",		 "//*[@id='OFFCAMP']");
		put("All locations",	 "//*[@id='ALL']");
	}};
	
	ClassSearch_Filters(WebDriver driver){
		this.driver=driver;
	}
	
	private WebElement inPerson(){
		WebElement elem=this.driver.findElement(By.xpath("//*[@id='typeSelectionCampus']"));
		return elem;
	}

	private WebElement online(){
		WebElement elem=this.driver.findElement(By.xpath("//*[@id='typeSelectionOnline']"));
		return elem;
	}
	
	private WebElement openClasses(){
		WebElement elem=this.driver.findElement(By.xpath("//*[@id='searchTypeOpen']"));
		return elem;
	}
	
	private WebElement allClasses(){
		WebElement elem=this.driver.findElement(By.xpath("//*[@id='searchTypeAllClass']"));
		return elem;
	}
	
	//*[@id="sessionA"]	//*[@id="sessionB"]	//*[@id="sessionC"]	//*[@id="sessionDYN"]
	
	private WebElement sessionFilter(String session){
		WebElement elem=this.driver.findElement(By.xpath("//*[@id='session"+session+"']"));
		return elem;
	}
	
	private WebElement locationFilter(String location){
		WebElement elem=this.driver.findElement(By.xpath(locationxPath.get(location)));
		return elem;
	}

}
