package edu.asu.classsearch.pages;

import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class classearch_add_a_class extends classearch_commons{
	
	private static WebDriver driver;
	public void load_driver(){
		classearch_add_a_class page=new classearch_add_a_class();
		driver=page.getDriver();
	}
	//property
	private static Select  instructor(){
		Select elem=new Select(driver.findElement(By.xpath("//select[@class='PSDROPDOWNLIST']")));
		return elem;
	}
	private static WebElement next(){
		WebElement elem =driver.findElement(By.xpath("//a[@id='DERIVED_CLS_DTL_NEXT_PB']"));
		return elem;
	}
	
	public void select_an_instructor(){
		Select elem=instructor();
		elem.deselectByIndex(1);
	}
	public void navigate_next(){
		WebElement elem=next();
		elem.clear();
	}
}
