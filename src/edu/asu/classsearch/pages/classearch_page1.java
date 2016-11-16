package edu.asu.classsearch.pages;

import java.sql.Driver;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class classearch_page1 {
	
	private  WebDriver driver;
	public classearch_page1(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}
	//property
	public void select_frame(){
		
	WebElement s=	driver.switchTo().frame(0).switchTo().frame("frame2").switchTo().frame(0).findElement(By.id("SubFrame"));
	driver.switchTo().frame(s.findElement(By.name("TargetContent")));
	}
	//property
	private  Select  instructor(){
		
		Select elem=new Select(driver.findElement(By.xpath("//select[@id='DERIVED_CLS_DTL_INSTRUCTOR_ID$128$']")));
		return elem;
	}
	private WebElement next(){
		WebElement elem =driver.findElement(By.xpath("//a[@id='DERIVED_CLS_DTL_NEXT_PB']"));
		return elem;
	}
	
	public  void select_an_instructor(){
		Select elem=instructor();
		elem.selectByIndex(1);
	}
	public  void navigate_next(){
		WebElement elem=next();
		elem.click();
	}
}
